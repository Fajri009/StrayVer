package com.fajri.strayver.data.repository

import android.content.Context
import android.net.Uri
import android.util.Log
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.model.DonasiModelResponse
import com.fajri.strayver.model.Donasi
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.storage
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.time.LocalDateTime
import java.util.UUID

class DonasiRepository {
    private val db: DatabaseReference =
        FirebaseDatabase
            .getInstance("https://strayver-6c1c0-default-rtdb.asia-southeast1.firebasedatabase.app")
            .reference
            .child("Donasi")
    private val donasiStorage = Firebase.storage.reference.child("images/")
    var imageAdress: String? = null
    var currentDonasi: DonasiModelResponse? = null

    fun notEmpty(context: Context) {
        var notEmpty: Boolean?
    }

    fun createProyekDonasi(
        donasiData: Donasi,
        context: Context,
        imageUri: Uri
    ) =
        callbackFlow<Resource<String>> {
            trySend(Resource.Loading())

            val imageId = donasiData.donasiId
            val photoRef = donasiStorage.child("donasi/$imageId")

            val imageByteArray: ByteArray? = context.contentResolver
                .openInputStream(imageUri)
                .use {
                    it?.readBytes()
                }

            try {
                val uploadImage = photoRef.putBytes(imageByteArray!!)
                    .addOnSuccessListener {
                        photoRef.downloadUrl.addOnSuccessListener {

                            imageAdress = it.toString()
                            if (imageAdress != null) {
                                val donasi =
                                    Donasi(
                                        donasiId = donasiData.donasiId,
                                        title = donasiData.title,
                                        donasiGoal = donasiData.donasiGoal,
                                        donasiGain = donasiData.donasiGain,
                                        deskripsi = donasiData.deskripsi,
                                        alamat = donasiData.alamat,
                                        gambar = imageAdress!!,
                                        relawanAvatar = "",
                                        relawanNama = donasiData.relawanNama,
                                        waktu = donasiData.waktu,
                                        userId = donasiData.userId,
                                        category = donasiData.category,
                                    )
                                db
                                    .child(donasiData.donasiId)
                                    .setValue(donasi)
                                    .addOnCompleteListener {
                                        if (it.isSuccessful) {
                                            trySend(Resource.Success(data = "Berhasil Membuat Proyek Donasi"))
                                        }
                                    }
                                    .addOnFailureListener {
                                        trySend(Resource.Error(message = "Proses Registrasi Gagal\n${it.message}"))
                                    }
                            }
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

    fun getAllDonasi() =
        callbackFlow<Resource<List<DonasiModelResponse>>> {
            trySend(Resource.Loading())

            db.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val donasi = snapshot.children.map {
                        DonasiModelResponse(it.getValue(Donasi::class.java), it.key)
                    }
                    trySend(Resource.Success(donasi))
                }

                override fun onCancelled(error: DatabaseError) {
                    trySend(Resource.Error(error.toString()))
                }
            })

            awaitClose {
                close()
            }
        }

    fun getDonasiById(id: String) =
        callbackFlow<Resource<DonasiModelResponse>> {
            trySend(Resource.Loading())

            db.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val donasi = snapshot.children.map {
                        DonasiModelResponse(it.getValue(Donasi::class.java), it.key)
                    }.filter { it.key == id }
                    currentDonasi = donasi[0]
                    trySend(Resource.Success(donasi[0]))
                }

                override fun onCancelled(error: DatabaseError) {
                    trySend(Resource.Error(error.toString()))
                }
            })

            awaitClose {
                close()
            }
        }

    fun updateDonasiGain(donasiId: String, value: Long) =
        callbackFlow<Resource<String>> {
            trySend(Resource.Loading())

            db.child(donasiId).child("donasiGain")
                .setValue(currentDonasi!!.item!!.donasiGain + value)
                .addOnSuccessListener {
                    trySend(Resource.Success(data = "Berhasil melakukan donasii"))
                }
                .addOnFailureListener {
                    trySend(Resource.Error("Berhasil Membuat Proyek Donasi"))
                }

            awaitClose {
                close()
            }
        }

    fun getDonasiByCategory(categoty: String) =
        callbackFlow<Resource<List<DonasiModelResponse>>> {
            trySend(Resource.Loading())

            db.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val donasi = snapshot.children.map {
                        DonasiModelResponse(it.getValue(Donasi::class.java), it.key)
                    }.filter { it.item!!.category == categoty }
                    trySend(Resource.Success(donasi))
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