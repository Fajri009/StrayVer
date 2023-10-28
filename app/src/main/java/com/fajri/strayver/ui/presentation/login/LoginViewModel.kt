package com.fajri.strayver.ui.presentation.login

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.fajri.strayver.data.FirebaseRepository
import com.fajri.strayver.data.OnBoardRepository
import com.fajri.strayver.util.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: OnBoardRepository,
    private val firebase: FirebaseRepository
) : ViewModel() {

    private val _email: MutableState<String> = mutableStateOf("")
    val email: State<String> = _email

    private val _sandi: MutableState<String> = mutableStateOf("")
    val sandi: State<String> = _sandi

    private val _isChecked: MutableState<Boolean> =  mutableStateOf(false)
    val isChecked: State<Boolean> = _isChecked

    fun handleBlank(context: Context) {
        Toast.makeText(context, "Email dan sandi tidak boleh kosong", Toast.LENGTH_SHORT).show()
    }

    fun onSubmit(context: Context) {
        if (_email.value.isEmpty() || _sandi.value.isEmpty()) {
            handleBlank(context)
        }
    }

    fun onChangeEmail(value: String) {
        _email.value = value
    }

    fun onChangePassword(value: String) {
        _sandi.value = value
    }

    fun onChecked() {
        _isChecked.value = !_isChecked.value
    }
}
