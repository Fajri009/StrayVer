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
import java.util.UUID

class DonasiRepository {
    private val db: DatabaseReference =
        FirebaseDatabase
            .getInstance("https://strayver-6c1c0-default-rtdb.asia-southeast1.firebasedatabase.app")
            .reference
            .child("Donasi")
    private val donasiStorage= Firebase.storage.reference.child("images/")

    fun notEmpty(context: Context) {
        var notEmpty: Boolean?
    }
    fun createProyekDonasi(
        donasiData: Donasi,
    ) =
        callbackFlow<Resource<String>> {
            trySend(Resource.Loading())

            db
                .child(donasiData.donasiId)
                .setValue(donasiData)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        trySend(Resource.Success(data = "Berhasil Membuat Proyek Donasi"))
                    }
                }
                .addOnFailureListener {
                    trySend(Resource.Error(message = "Proses Registrasi Gagal\n${it.message}"))
                }
            awaitClose {
                close()
            }
        }

    fun kirimDonasi(context: Context, imageUri: Uri): Flow<Resource<String>> =
        callbackFlow {
            trySend(Resource.Loading())

            val imageId= UUID.randomUUID()
            var imageAddress= ""
            val photoRef= donasiStorage.child("barang_donasi/$imageId")

            val imageByteArray: ByteArray? = context.contentResolver
                .openInputStream(imageUri)
                .use {
                    it?.readBytes()
                }

            try {
                val uploadImage= photoRef.putBytes(imageByteArray!!)
                    .addOnSuccessListener {
                        imageAddress= it.uploadSessionUri.toString()
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