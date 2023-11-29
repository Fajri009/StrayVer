package com.fajri.strayver.ui.presentation.relawan.editProfil

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.model.UserModelResponse
import com.fajri.strayver.data.repository.UserRepository
import com.fajri.strayver.model.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RelawanEditViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {

    private val _isLoading= mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _userData = mutableStateOf(UserData())
    val userData: State<UserData> = _userData

    private val _imageUri = mutableStateOf<Uri?>(null)
    val imageUri: State<Uri?> = _imageUri

    private val _nama: MutableState<String> = mutableStateOf("")
    val nama: State<String> = _nama

    private val _username: MutableState<String> = mutableStateOf("")
    val username: State<String> = _username

    private val _deskripsi: MutableState<String> = mutableStateOf("")
    val deskripsi: State<String> = _deskripsi

    private val _email: MutableState<String> = mutableStateOf("")
    val email: State<String> = _email

    private val _alamat: MutableState<String> = mutableStateOf("")
    val alamat: State<String> = _alamat

    private val _noTelp: MutableState<String> = mutableStateOf("")
    val noTelp: State<String> = _noTelp

    private val _password: MutableState<String> = mutableStateOf("")
    val password: State<String> = _password

    private val _isReVisible: MutableState<Boolean> = mutableStateOf(false)
    val isReVisible: State<Boolean> = _isReVisible

    fun setImageUri(uri: Uri) {
        _imageUri.value = uri
    }

    fun onChangeName(value: String) {
        _nama.value = value
    }

    fun onChangeUsername(value: String) {
        _username.value = value
    }

    fun onChangeDeskripsi(value: String) {
        _deskripsi.value = value
    }

    fun onChangeEmail(value: String) {
        _email.value = value
    }

    fun onChangeAlamat(value: String) {
        _alamat.value = value
    }

    fun onChangeTelp(value: String) {
        _noTelp.value = value
    }

    fun onChangePassword(value:String) {
        _password.value = value
    }

    fun onTogglePassword(value: Boolean) {
        _isReVisible.value = value
    }

    fun onChangeLoadingState(value: Boolean) {
        _isLoading.value = value
    }

    fun getUserData() {
        viewModelScope.launch {
            userRepository.getUserById().collect {
                when (it) {
                    is Resource.Loading -> {
                        _isLoading.value= true
                    }
                    is Resource.Success -> {
                        _userData.value = it.data!!.item!!
                        _imageUri.value = Uri.parse(_userData.value.avatar)
                        _nama.value= _userData.value.nama
                        _username.value = _userData.value.username
                        _deskripsi.value = _userData.value.deskripsi
                        _email.value = _userData.value.email
                        _alamat.value = _userData.value.alamat
                        _noTelp.value = _userData.value.telp
                        _password.value = _userData.value.password
                        _isLoading.value= false
                    }
                    is Resource.Error -> {
                        UserModelResponse(item = null, key = null)
                    }
                }
            }
        }
    }

    fun updateProfil(): Flow<Resource<String>> {
        val user = UserData (
            avatar = _imageUri.value.toString(),
            nama = _nama.value,
            username = _username.value,
            email = _email.value,
            deskripsi = _deskripsi.value,
            telp = _noTelp.value,
            alamat = _alamat.value,
            password = _password.value,
        )

        return userRepository.updateUserProfile(user)
    }
}