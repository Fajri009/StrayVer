package com.fajri.strayver.data.repository

import android.content.Context
import android.net.Uri
import android.util.Log
import com.fajri.strayver.data.Resource
import com.fajri.strayver.model.Donasi
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
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
    lateinit var imageAdress: String

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
                            Log.i("cok", it.toString())

                            val imageUrl: String? = it.toString()
                            imageUrl?.let {
                                val donasi=
                                    donasiData.apply {
                                        Donasi(
                                            donasiId = donasiId,
                                            title = title,
                                            donasiGoal = donasiGoal,
                                            donasiGain = donasiGain,
                                            deskripsi = deskripsi,
                                            alamat = alamat,
                                            gambar = it.toString(),
                                            relawanAvatar = "",
                                            relawanNama = relawanNama,
                                            waktu = waktu,
                                            userId = userId,
                                            category = category,
                                        )
                                    }

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

    fun kirimDonasi(context: Context, imageUri: Uri): Flow<Resource<String>> =
        callbackFlow {
            trySend(Resource.Loading())

            val imageId = UUID.randomUUID()
            val photoRef = donasiStorage.child("barang_donasi/$imageId")

            val imageByteArray: ByteArray? = context.contentResolver
                .openInputStream(imageUri)
                .use {
                    it?.readBytes()
                }

            try {
                val uploadImage = photoRef.putBytes(imageByteArray!!)
                    .addOnSuccessListener {
                        imageAdress = it.uploadSessionUri.toString()
                        trySend(Resource.Success(it.uploadSessionUri.toString()))
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
}