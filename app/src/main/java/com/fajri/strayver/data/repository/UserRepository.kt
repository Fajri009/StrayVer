package com.fajri.strayver.data.repository

import android.content.Context
import android.util.Log
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
    private var userDb = FirebaseDatabase.getInstance("https://strayver-6c1c0-default-rtdb.asia-southeast1.firebasedatabase.app")
    var user: FirebaseUser? = null

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
        context: Context,
        userRole: String
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    user = auth.currentUser

                    when(userRole) {
                        "member" -> {
                            navController.popBackStack()
                            navController.navigate(Route.MEMBER_HOME)
                        }
                        "relawan" -> {
                            navController.popBackStack()
                            navController.navigate(Route.RELAWAN_HOME)
                        }
                    }
                }
            }
            .addOnFailureListener {
                Toast.makeText(context, "Email atau password salah", Toast.LENGTH_SHORT).show()
            }
    }

    fun registerUser(
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
            .addOnFailureListener {
            }
    }

    fun createUser(
        userData: UserData,
        uid: String,
        context: Context,
        showDialog: MutableState<Boolean>
    ) {
        val reference= userDb.getReference("Users")
        reference.child(uid)
            .setValue(userData)
            .addOnCompleteListener {
                showDialog.value= true
            }
    }
}