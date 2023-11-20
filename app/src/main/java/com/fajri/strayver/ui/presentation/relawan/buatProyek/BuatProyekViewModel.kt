package com.fajri.strayver.ui.presentation.relawan.buatProyek

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.repository.DonasiRepository
import com.fajri.strayver.model.Donasi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class BuatProyekViewModel @Inject constructor(
    private val donasiRepository: DonasiRepository
): ViewModel() {
    private val _namaProyek: MutableState<String> = mutableStateOf("")
    val namaProyek: State<String> = _namaProyek

    private val _deskripsi: MutableState<String> = mutableStateOf("")
    val deskripsi: State<String> = _deskripsi

    private val _jumlahMaks: MutableState<Long?> = mutableStateOf(null)
    val jumlahMaks: State<Long?> = _jumlahMaks

    private val _isShowDialog: MutableState<Boolean> = mutableStateOf(false)
    val isShowDialog: State<Boolean> = _isShowDialog

    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    var donasiType = ""

    fun onChangeNamaProyek(value: String) {
        _namaProyek.value = value
    }

    fun onChangeDeskripsi(value: String) {
        _deskripsi.value = value
    }

    fun onChangeJumlahMaks(value: Long?) {
        _jumlahMaks.value = value
    }

    fun setLoading(state: Boolean) {
        _isLoading.value = state
    }

    fun setDialog(state: Boolean) {
        _isShowDialog.value = state
    }

    fun isValid(context: Context): Boolean {
        var isValid: Boolean = true

        if (_namaProyek.value.isEmpty() || _deskripsi.value.isEmpty() || _jumlahMaks.value.toString().isEmpty()) {
            Toast.makeText(context, "Semua data harus diisi", Toast.LENGTH_SHORT).show()
            isValid = false
        }

        return isValid
    }

    fun buatProyek(): Flow<Resource<String>> {
        val id= UUID.randomUUID().toString()
        val donasi = Donasi(
            donasiId = id,
            title = _namaProyek.value,
            donasiGoal = _jumlahMaks.value!!,
            donasiGain = 0,
            deskripsi = _deskripsi.value,
            alamat = "",
            gambar = "",
            relawanAvatar = "",
            relawanNama = "",
            waktu = LocalDateTime.now().toString(),
            userId = "",
            category = donasiType,
        )

        return donasiRepository.createProyekDonasi(
            donasiData = donasi
        )
    }
}