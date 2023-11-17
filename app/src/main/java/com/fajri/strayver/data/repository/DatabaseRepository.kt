package com.fajri.strayver.data.repository

import android.util.Log
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.model.ArtikelModelResponse
import com.fajri.strayver.model.Artikel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class DatabaseRepository {
    private var db: DatabaseReference =
        FirebaseDatabase
            .getInstance("https://strayver-6c1c0-default-rtdb.asia-southeast1.firebasedatabase.app")
            .reference

    fun getArtikel(): Flow<Resource<List<ArtikelModelResponse>>> =
        callbackFlow {
            trySend(Resource.Loading())

            Log.i("hitung", "onDataChange: ")

            db.child("Artikel").addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val items= snapshot.children.map {
                        ArtikelModelResponse(it.getValue(Artikel::class.java), it.key)
                    }
                    trySend(Resource.Success(items))
                }

                override fun onCancelled(error: DatabaseError) {
                    trySend(Resource.Error("Tidak bisa mengambil data\n${error.message}"))
                }

            })

            awaitClose {
                close()
            }
        }
}