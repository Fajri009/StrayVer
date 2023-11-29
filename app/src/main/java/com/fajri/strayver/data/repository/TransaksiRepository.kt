package com.fajri.strayver.data.repository

import android.content.Context
import android.net.Uri
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.model.DonasiModelResponse
import com.fajri.strayver.data.model.TransaksiModelResponse
import com.fajri.strayver.model.Donasi
import com.fajri.strayver.model.Transaksi
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.storage.storage
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

class TransaksiRepository {
    private val db: DatabaseReference =
        FirebaseDatabase
            .getInstance("https://strayver-6c1c0-default-rtdb.asia-southeast1.firebasedatabase.app")
            .reference
            .child("Transaksi")
    private val transaksiStorage = Firebase.storage.reference.child("images/")
    var imageAdress: String? = null

    fun addTransaksiBarang(transaksiData: Transaksi, context: Context, imageUri: Uri) =
        callbackFlow<Resource<String>> {
            trySend(Resource.Loading())

            val imageId = transaksiData.transaksiId
            val photoRef = transaksiStorage.child("transaksi/$imageId")

            val imageByteArray: ByteArray? = context.contentResolver
                .openInputStream(imageUri)
                .use {
                    it?.readBytes()
                }

            try {
                photoRef.putBytes(imageByteArray!!)
                    .addOnSuccessListener {
                        photoRef.downloadUrl.addOnSuccessListener {
                            imageAdress = it.toString()

                            if (imageAdress != null) {
                                val trans =
                                    Transaksi(
                                        transaksiId = transaksiData.transaksiId,
                                        donasiId = transaksiData.donasiId,
                                        donasiType = transaksiData.donasiType,
                                        title = transaksiData.title,
                                        namaRelawan = transaksiData.namaRelawan,
                                        namaMember = transaksiData.namaMember,
                                        income = transaksiData.income,
                                        tanggal = transaksiData.tanggal,
                                        resi = transaksiData.resi,
                                        idMember = transaksiData.idMember,
                                        idRelawan = transaksiData.idRelawan,
                                        status = transaksiData.status,
                                        ekspedisi = transaksiData.ekspedisi,
                                        deskripsi = transaksiData.deskripsi,
                                        gambar = imageAdress.toString(),
                                        metodePembayaran = transaksiData.metodePembayaran
                                    )
                                db
                                    .child(transaksiData.transaksiId)
                                    .setValue(trans)
                                    .addOnSuccessListener {
                                        trySend(Resource.Success("Berhasil mengirimkan barang"))
                                    }
                                    .addOnFailureListener {
                                        trySend(Resource.Error(it.message.toString()))
                                    }
                            }
                        }.addOnFailureListener {
                            trySend(Resource.Error(it.message.toString()))
                        }
                    }
                    .addOnFailureListener {
                        trySend(Resource.Error(it.message.toString()))
                    }
            } catch (e: Exception) {
                trySend(Resource.Error(e.message.toString()))
            }
            awaitClose {
                close()
            }
        }

    fun addTransaksiDana(transaksiData: Transaksi) =
        callbackFlow<Resource<String>> {
            trySend(Resource.Loading())

            db.child(transaksiData.transaksiId).setValue(transaksiData)
                .addOnSuccessListener {
                    trySend(Resource.Success("Berhasil mengirimkan dana"))
                }
                .addOnFailureListener {
                    trySend(Resource.Error(it.message.toString()))
                }

            awaitClose {
                close()
            }
        }

    fun updateStatus(transaksi: Transaksi) =
        callbackFlow<Resource<String>> {
            trySend(Resource.Loading())

            db
        }

    fun getTransaksi(user: String, type: String) =
        callbackFlow<Resource<List<TransaksiModelResponse>>> {
            trySend(Resource.Loading())

            if (type == "Semua") {
                db.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val transaksi = snapshot.children.map {
                            TransaksiModelResponse(it.getValue(Transaksi::class.java), it.key)
                        }.filter { it.item!!.idMember == user }
                        trySend(Resource.Success(transaksi))
                    }

                    override fun onCancelled(error: DatabaseError) {
                        trySend(Resource.Error(error.message))
                    }
                })
            } else {
                db.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val transaksi = snapshot.children.map {
                            TransaksiModelResponse(it.getValue(Transaksi::class.java), it.key)
                        }.filter {
                            it.item!!.donasiType == type && it.item!!.idMember == user
                        }
                        trySend(Resource.Success(transaksi))
                    }

                    override fun onCancelled(error: DatabaseError) {
                        trySend(Resource.Error(error.message))
                    }
                })
            }

            awaitClose {
                close()
            }
        }

    fun getTransaksiByIdRelawan(user: String, type: String) =
        callbackFlow<Resource<List<TransaksiModelResponse>>> {
            trySend(Resource.Loading())

            if (type == "Semua") {
                db.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val transaksi = snapshot.children.map {
                            TransaksiModelResponse(it.getValue(Transaksi::class.java), it.key)
                        }.filter {
                            it.item!!.idRelawan == user
                        }
                        trySend(Resource.Success(transaksi))
                    }

                    override fun onCancelled(error: DatabaseError) {
                        trySend(Resource.Error(error.message))
                    }
                })
            } else {
                db.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val transaksi = snapshot.children.map {
                            TransaksiModelResponse(it.getValue(Transaksi::class.java), it.key)
                        }.filter {
                            it.item!!.donasiType == type && it.item!!.idRelawan == user
                        }
                        trySend(Resource.Success(transaksi))
                    }

                    override fun onCancelled(error: DatabaseError) {
                        trySend(Resource.Error(error.message))
                    }
                })
            }

            awaitClose {
                close()
            }
        }

    fun getTransaksiByIdDonasi(donasiId: String) =
        callbackFlow<Resource<List<TransaksiModelResponse>>> {
            trySend(Resource.Loading())

            db.addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val transaksi = snapshot.children.map {
                        TransaksiModelResponse(it.getValue(Transaksi::class.java), it.key)
                    }.filter {
                        it.item!!.donasiId == donasiId
                    }
                    trySend(Resource.Success(transaksi))
                }

                override fun onCancelled(error: DatabaseError) {
                    trySend(Resource.Error(error.message))
                }
            })

            awaitClose {
                close()
            }
        }

    fun transaksiSearchQuery(query: String, user: String) =
        callbackFlow<Resource<List<TransaksiModelResponse>>> {
            trySend(Resource.Loading())

            db.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val transaksi = snapshot.children.map {
                        TransaksiModelResponse(it.getValue(Transaksi::class.java), it.key)
                    }.filter {
                        (it.item!!.title).lowercase().contains(query) && it.item!!.idMember == user
                    }
                    trySend(Resource.Success(transaksi))
                }

                override fun onCancelled(error: DatabaseError) {
                    trySend(Resource.Error(error.toString()))
                }
            })

            awaitClose {
                close()
            }
        }

    fun transaksiSearchQueryByIdRelawan(query: String, user: String) =
        callbackFlow<Resource<List<TransaksiModelResponse>>> {
            trySend(Resource.Loading())

            db.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val transaksi = snapshot.children.map {
                        TransaksiModelResponse(it.getValue(Transaksi::class.java), it.key)
                    }.filter {
                        (it.item!!.title).lowercase().contains(query) && it.item!!.idRelawan == user
                    }
                    trySend(Resource.Success(transaksi))
                }

                override fun onCancelled(error: DatabaseError) {
                    trySend(Resource.Error(error.toString()))
                }
            })

            awaitClose {
                close()
            }
        }
    fun getTransaksiById(transaksiId: String) =
        callbackFlow<Resource<TransaksiModelResponse>> {
            trySend(Resource.Loading())

            db.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val transaksi= snapshot.children.map {
                        TransaksiModelResponse(it.getValue(Transaksi::class.java), it.key)
                    }.filter { it.key == transaksiId}
                    trySend(Resource.Success(transaksi[0]))
                }

                override fun onCancelled(error: DatabaseError) {
                    trySend(Resource.Error(error.toString()))
                }
            })
            awaitClose {
                close()
            }
        }
}
