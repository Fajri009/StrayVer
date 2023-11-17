package com.fajri.strayver.data.repository

import androidx.compose.runtime.MutableState
import com.fajri.strayver.model.DonasiData
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DonasiRepository {
    private var db: DatabaseReference =
        FirebaseDatabase
            .getInstance("https://strayver-6c1c0-default-rtdb.asia-southeast1.firebasedatabase.app")
            .reference

//    fun createProyekDonasi(
//        donasiData: DonasiData
//        showDialog: MutableState<Boolean>
//    )
}