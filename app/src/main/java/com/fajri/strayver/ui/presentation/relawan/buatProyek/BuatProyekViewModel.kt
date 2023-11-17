package com.fajri.strayver.ui.presentation.relawan.buatProyek

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.fajri.strayver.data.repository.UserRepository
import com.fajri.strayver.util.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class BuatProyekViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {
    private val _namaProyek: MutableState<String> = mutableStateOf("")
    val namaProyek: State<String> = _namaProyek

    private val _deskripsi: MutableState<String> = mutableStateOf("")
    val deskripsi: State<String> = _deskripsi

    private val _jumlahMaks: MutableState<String> = mutableStateOf("")
    val jumlahMaks: State<String> = _jumlahMaks

    fun onChangeNamaProyek(value: String) {
        _namaProyek.value = value
    }

    fun onChangeDeskripsi(value: String) {
        _deskripsi.value = value
    }

    fun onChangeJumlahMaks(value: String) {
        _jumlahMaks.value = value
    }

    fun buatProyek() {
//        val proyek
    }
}