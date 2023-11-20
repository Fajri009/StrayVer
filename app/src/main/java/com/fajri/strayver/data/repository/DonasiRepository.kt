package com.fajri.strayver.data.repository

import android.content.Context
import android.util.Log
import com.fajri.strayver.data.Resource
import com.fajri.strayver.model.Donasi
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

class DonasiRepository {
    private var db: DatabaseReference =
        FirebaseDatabase
            .getInstance("https://strayver-6c1c0-default-rtdb.asia-southeast1.firebasedatabase.app")
            .reference
            .child("Donasi")

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
                        Log.i("cok dapet", "createProyekDonasi: ")
                        trySend(Resource.Success(data = "Berhasil Membuat Proyek Donasi"))
                    }
                }
                .addOnFailureListener {
                    Log.i("cok asu", "createProyekDonasi: gagal")
                    trySend(Resource.Error(message = "Proses Registrasi Gagal\n${it.message}"))
                }
            awaitClose {
                close()
            }
        }
}