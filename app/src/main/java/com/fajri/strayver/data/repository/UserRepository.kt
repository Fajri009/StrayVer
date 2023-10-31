package com.fajri.strayver.data.repository

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.database

class UserRepository() {
    private var auth = FirebaseAuth.getInstance()
    private var db = Firebase.database.reference

    fun resetPassword(email: String, showDialog: MutableState<Boolean>, context: Context) {
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    showDialog.value= true
                } else {
                    Toast.makeText(context, "Email tidak terdaftar", Toast.LENGTH_SHORT).show()
                }
            }
    }
}