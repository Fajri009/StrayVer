package com.fajri.strayver.data.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.model.UserModelResponse
import com.fajri.strayver.model.UserData
import com.fajri.strayver.util.Route
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class UserRepository() {
    private var auth = FirebaseAuth.getInstance()
    private var userDb = FirebaseDatabase
        .getInstance("https://strayver-6c1c0-default-rtdb.asia-southeast1.firebasedatabase.app")
        .getReference("Users")
    var user: FirebaseUser? = null

    fun resetPassword(email: String): Flow<Resource<String>> =
        callbackFlow {
            trySend(Resource.Loading())

            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        trySend(Resource.Success("Password Berhasil diubah"))
                    }
                }
                .addOnFailureListener {
                    trySend(Resource.Error("Gagal mengubah password\n${it.message}"))
                }
            awaitClose {
                close()
            }
        }

    fun login(
        email: String,
        password: String,
    ): Flow<Resource<String>> =
        callbackFlow {
            trySend(Resource.Loading())

            auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    user = it.user!!
                    trySend(Resource.Success("Berhasil Login"))

                }
                .addOnFailureListener {
                    trySend(Resource.Error(message = "Akun Anda Belum Terdaftar"))
                }
            awaitClose {
                close()
            }
        }

    fun registerUser(
        userData: UserData,
    ) =
        callbackFlow<Resource<String>> {
            trySend(Resource.Loading())

            auth.createUserWithEmailAndPassword(userData.email, userData.password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val userId = task.result.user!!.uid

                        userDb.child(userId)
                            .setValue(userData)
                            .addOnCompleteListener {
                                if (it.isSuccessful) {
                                    trySend(Resource.Success(data = "Berhasil"))
                                }
                            }

                    } else {
                        trySend(Resource.Error(message = "Proses Registrasi Gagal"))
                    }
                }
                .addOnFailureListener {
                    trySend(Resource.Error(message = "Proses Registrasi Gagal\n${it.message}"))
                }
            awaitClose {
                close()
            }
        }

    fun getUserById(): Flow<Resource<UserModelResponse>> =
        callbackFlow {
            trySend(Resource.Loading())

            userDb.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val user = snapshot.children.map {
                        UserModelResponse(it.getValue(UserData::class.java), it.key)
                    }.filter { it.key == user!!.uid }

                    trySend(Resource.Success(user[0]))
                }

                override fun onCancelled(error: DatabaseError) {
                    trySend(Resource.Error(message = error.message.toString()))
                }
            })
            awaitClose {
                close()
            }
        }

    fun updateUserProfile(userData: UserData): Flow<Resource<String>> =
        callbackFlow {
            trySend(Resource.Loading())

            userDb.child(user!!.uid).setValue(userData)
                .addOnSuccessListener {
                    trySend(Resource.Success("Berhasil mengubah data"))
                }
                .addOnFailureListener {
                    trySend(Resource.Error("Gagal mengubah data\n${it.message}"))
                }

            awaitClose {
                close()
            }

        }

    fun logout() {
        auth.signOut()
        user = null
    }
}