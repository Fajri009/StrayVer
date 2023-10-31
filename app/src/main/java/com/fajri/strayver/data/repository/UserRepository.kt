package com.fajri.strayver.data.repository

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import com.fajri.strayver.util.Route
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.database

class UserRepository() {
    private var auth = FirebaseAuth.getInstance()
    private var db = Firebase.database.reference

    suspend fun resetPassword(email: String, showDialog: MutableState<Boolean>, context: Context) {
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    showDialog.value= true
                } else {
                    Toast.makeText(context, "Email tidak terdaftar", Toast.LENGTH_SHORT).show()
                }
            }
    }

    suspend fun login(email: String, password: String, navController: NavController, context: Context) {
        val user = auth.currentUser
//        auth.signOut()
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {navController.popBackStack()
                    navController.navigate(Route.MEMBER_HOME)

                }
            }
            .addOnFailureListener {
                Toast.makeText(context, "Email atau password salah", Toast.LENGTH_SHORT).show()
            }
    }
}