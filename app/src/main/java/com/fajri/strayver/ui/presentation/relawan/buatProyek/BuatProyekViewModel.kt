package com.fajri.strayver.ui.presentation.relawan.buatProyek

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.fajri.strayver.util.Route
import java.util.Date
import javax.inject.Inject

class BuatProyekViewModel @Inject constructor(
//    private val navController: NavController
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
}