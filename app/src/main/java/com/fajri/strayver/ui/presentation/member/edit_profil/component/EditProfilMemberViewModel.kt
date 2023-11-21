package com.fajri.strayver.ui.presentation.member.edit_profil.component

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
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditProfilMemberViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val repository: OnBoardRepository
) : ViewModel() {

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _userData = mutableStateOf<UserData>(UserData())
    val userData: State<UserData> = _userData

    private val _nama: MutableState<String> = mutableStateOf("")
    val nama: State<String> = _nama

    private val _usernmae: MutableState<String> = mutableStateOf("")
    val username: State<String> = _usernmae

    private val _deskripsi: MutableState<String> = mutableStateOf("")
    val deskripsi: State<String> = _deskripsi

    private val _email: MutableState<String> = mutableStateOf("")
    val email: State<String> = _email

    private val _telp: MutableState<String> = mutableStateOf("")
    val telp: State<String> = _telp

    private val _alamat: MutableState<String> = mutableStateOf("")
    val alamat: State<String> = _alamat

    private val _password: MutableState<String> = mutableStateOf("")
    val password: State<String> = _password

    fun onChangeNama(value: String) {
        _nama.value = value
    }

    fun onChangeUsername(value: String) {
        _usernmae.value = value
    }

    fun onChangeDeskripsi(value: String) {
        _deskripsi.value = value
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

    fun onChangeLoadingState(state: Boolean) {
        _isLoading.value= state
    }

    fun getUserData() {
        viewModelScope.launch {
            userRepository.getUserById().collect {
                when (it) {
                    is Resource.Loading -> _isLoading.value = true
                    is Resource.Success -> {
                        _userData.value = it.data!!.item!!
                        _nama.value= _userData.value.nama
                        _usernmae.value= _userData.value.username
                        _deskripsi.value= _userData.value.deskripsi
                        _email.value= _userData.value.email
                        _alamat.value= _userData.value.alamat
                        _telp.value= _userData.value.telp
                        _password.value= _userData.value.password
                        _isLoading.value = false
                    }

                    is Resource.Error -> _isLoading.value = false
                }
            }
        }
    }

    fun updateProfil(): Flow<Resource<String>> {

        val user = UserData(
            nama = _nama.value,
            username = _usernmae.value,
            deskripsi= _deskripsi.value,
            email = _email.value,
            telp = _telp.value,
            alamat = _alamat.value,
            password = _password.value,
            role = _userData.value.role,
            saldo = _userData.value.saldo
        )

        return userRepository.updateUserProfile(user)
    }
}