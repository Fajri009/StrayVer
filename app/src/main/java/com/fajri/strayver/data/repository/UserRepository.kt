package com.fajri.strayver.data.repository

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import com.fajri.strayver.model.UserData
import com.fajri.strayver.util.Route
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase

class UserRepository() {
    private var auth = FirebaseAuth.getInstance()
    private var userDb = FirebaseDatabase.getInstance().reference.child("users")
    private var user: FirebaseUser? = null

    suspend fun resetPassword(email: String, showDialog: MutableState<Boolean>, context: Context) {
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    showDialog.value = true
                } else {
                    Toast.makeText(context, "Email tidak terdaftar", Toast.LENGTH_SHORT).show()
                }
            }
    }

    suspend fun login(
        email: String,
        password: String,
        navController: NavController,
        context: Context
    ) {
        user = auth.currentUser
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val user = auth.currentUser
                    navController.popBackStack()
                    navController.navigate(Route.MEMBER_HOME)

                }
            }
            .addOnFailureListener {
                Toast.makeText(context, "Email atau password salah", Toast.LENGTH_SHORT).show()
            }
    }

    suspend fun registerUser(
        userData: UserData,
        context: Context,
        showDialog: MutableState<Boolean>
    ) {

        auth.createUserWithEmailAndPassword(userData.email, userData.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val userId= task.result.user!!.uid
                    createUser(userData, userId, context, showDialog)
                } else {
                    Toast.makeText(
                        context,
                        "Proses Registrasi Gagal",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
    }

    private fun createUser(
        userData: UserData,
        uid: String,
        context: Context,
        showDialog: MutableState<Boolean>
    ) {
        userDb.child(uid)
            .setValue(uid, userData)
            .addOnSuccessListener {
                showDialog.value = true
            }
            .addOnFailureListener {
                Toast.makeText(
                    context,
                    "Gagal membuat user: ${it.message}",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
    }
}