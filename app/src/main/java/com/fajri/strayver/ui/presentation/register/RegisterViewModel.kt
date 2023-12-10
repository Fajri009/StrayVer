package com.fajri.strayver.ui.presentation.register

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.repository.OnBoardRepository
import com.fajri.strayver.data.repository.UserRepository
import com.fajri.strayver.model.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val onBoardRepository: OnBoardRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private val _nama: MutableState<String> = mutableStateOf("")
    val nama: State<String> = _nama

    private val _usernmae: MutableState<String> = mutableStateOf("")
    val username: State<String> = _usernmae

    private val _email: MutableState<String> = mutableStateOf("")
    val email: State<String> = _email

    private val _telp: MutableState<String> = mutableStateOf("")
    val telp: State<String> = _telp

    private val _alamat: MutableState<String> = mutableStateOf("")
    val alamat: State<String> = _alamat

    private val _password: MutableState<String> = mutableStateOf("")
    val password: State<String> = _password

    private val _rePassword: MutableState<String> = mutableStateOf("")
    val rePassword: State<String> = _rePassword

    private val _isVisible: MutableState<Boolean> = mutableStateOf(false)
    val isVisible: State<Boolean> = _isVisible

    private val _isReVisible: MutableState<Boolean> = mutableStateOf(false)
    val isReVisible: State<Boolean> = _isReVisible

    private val _isShowDialog: MutableState<Boolean> = mutableStateOf(false)
    val isShowDialog: State<Boolean> = _isShowDialog

    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun onChangeNama(value: String) {
        _nama.value = value
    }

    fun onChangeUsername(value: String) {
        _usernmae.value = value
    }

    fun onChangeEmail(value: String) {
        _email.value = value
    }

    fun onChangeTelp(value: String) {
        _telp.value = value
    }

    fun onChangeAlamat(value: String) {
        _alamat.value = value
    }

    fun onChangePassword(value: String) {
        _password.value = value
    }

    fun onChangeRePassword(value: String) {
        _rePassword.value = value
    }

    fun setDialog(show: Boolean) {
        _isShowDialog.value = show
    }

    fun setLoading(state: Boolean) {
        _isLoading.value = state
    }


    fun isValid(context: Context): Boolean {

        var isValid: Boolean?


        if (_nama.value.isEmpty() || _usernmae.value.isEmpty() || _email.value.isEmpty() ||
            _telp.value.isEmpty() || _alamat.value.isEmpty() || _password.value.isEmpty() ||
            _rePassword.value.isEmpty()
        ) {
            Toast.makeText(context, "Semua data harus terisi", Toast.LENGTH_SHORT).show()
            isValid = false
            return isValid

        } else if (!_email.value.contains("@")) {
            Toast.makeText(context, "Email anda tidak valid", Toast.LENGTH_SHORT).show()
            isValid = false
            return isValid

        } else {
            if (_password.value != _rePassword.value) {
                Toast.makeText(context, "Masukkan password yang sama", Toast.LENGTH_SHORT)
                    .show()
                isValid = false
                return isValid
            }
        }
        isValid = true
        return isValid
    }

    fun onSubmit(): Flow<Resource<String>> {

        var userRole: String = ""

        viewModelScope.launch {
            onBoardRepository.getRole.collect { role ->
                userRole = role
            }
        }
        val user = UserData(
            nama = _nama.value,
            username = _usernmae.value,
            email = _email.value,
            telp = _telp.value,
            alamat = _alamat.value,
            password = _password.value,
            role = userRole,
            saldo = 1500000,
            avatar = "https://firebasestorage.googleapis.com/v0/b/strayver-6c1c0.appspot.com/o/images%2Fprofile%2Fdefault_avatar.jpg?alt=media&token=fde93e0a-c147-4ba1-8bdc-3d93f9c9a0cf"
        )

        return userRepository.registerUser(
            userData = user,
        )
    }

    fun onTogglePassword() {
        _isVisible.value = !_isVisible.value
    }

    fun onToggleRePassword() {
        _isReVisible.value = !_isReVisible.value
    }
}
