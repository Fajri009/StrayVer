package com.fajri.strayver.data.repository

import android.content.Context
import android.net.Uri
import com.fajri.strayver.data.Resource
import com.fajri.strayver.model.Transaksi
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
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
                            imageAdress= it.toString()

                            if (imageAdress != null) {
                                val trans=
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

    fun addTransaksiDana(transaksiData: Transaksi)=
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
}