package com.fajri.strayver.ui.presentation.login

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.fajri.strayver.util.Route

class LoginViewModel : ViewModel() {
    var email by mutableStateOf("")
    var sandi by mutableStateOf("")

    fun handleBlank(context: Context) {
        Toast.makeText(context, "Email dan sandi tidak boleh kosong", Toast.LENGTH_SHORT).show()
    }

    fun handleLupaSandi(navController: NavController) {
        navController.navigate(Route.LUPASANDI)
    }
}
