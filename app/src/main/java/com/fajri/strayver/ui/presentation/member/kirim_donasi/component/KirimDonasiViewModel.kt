package com.fajri.strayver.ui.presentation.member.kirim_donasi.component

import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.repository.DonasiRepository
import com.fajri.strayver.data.repository.TransaksiRepository
import com.fajri.strayver.data.repository.UserRepository
import com.fajri.strayver.model.Transaksi
import com.fajri.strayver.util.DonaturProgres
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class KirimDonasiViewModel @Inject constructor(
    private val donasiRepository: DonasiRepository,
    private val transaksiRepository: TransaksiRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    lateinit var context: Context

    var userId= userRepository.user!!.uid

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _showDialog = mutableStateOf(false)
    val showDialog: State<Boolean> = _showDialog

    private val _dana = mutableStateOf("")
    val dana: State<String> = _dana

    private val _metode = mutableStateOf("")
    val metode: State<String> = _metode

    private val _pengirim = mutableStateOf("")
    val pengirim: State<String> = _pengirim

    private val _deskripsi = mutableStateOf("")
    val deskripsi: State<String> = _deskripsi

    private val _ekspedisi = mutableStateOf("")
    val ekspedisi: State<String> = _ekspedisi

    private val _resi = mutableStateOf("")
    val resi: State<String> = _resi

    private val _jumlah = mutableStateOf("")
    val jumlah: State<String> = _jumlah

    private val _imageUri = mutableStateOf<Uri?>(null)
    val imageUri: State<Uri?> = _imageUri

    fun setMotode(metode: String) {
        _metode.value = metode
    }

    fun onDanaChange(dana: String) {
        _dana.value = dana
    }

    fun onPengirimChange(pengirim: String) {
        _pengirim.value = pengirim
    }

    fun onDeskripsiChange(deskripsi: String) {
        _deskripsi.value = deskripsi
    }

    fun onEkspedisiChange(ekspedisi: String) {
        _ekspedisi.value = ekspedisi
    }

    fun onResiChange(resi: String) {
        _resi.value = resi
    }

    fun onJumlahChange(jumlah: String) {
        _jumlah.value = jumlah
    }

    fun setImageUri(uri: Uri) {
        _imageUri.value = uri
    }

    fun setLoading(state: Boolean) {
        _isLoading.value = state
    }

    fun showDialog(state: Boolean) {
        _showDialog.value = state
    }

    fun donasiBarangSubmit(
        context: Context, namaDonasi: String, donasiId: String, donasiType:
        String, relawan: String, idRelawan: String
    ) {


        val trans = Transaksi(
            donasiId = donasiId,
            transaksiId = UUID.randomUUID().toString(),
            donasiType = donasiType,
            title = namaDonasi,
            namaRelawan = relawan,
            namaMember = _pengirim.value,
            income = _jumlah.value.toLong(),
            tanggal = System.currentTimeMillis(),
            resi = _resi.value,
            status = DonaturProgres.PROSES,
            ekspedisi = _ekspedisi.value,
            deskripsi = _deskripsi.value,
            metodePembayaran = _metode.value,
            gambar = "",
            idMember = userId,
            idRelawan = idRelawan
        )

        viewModelScope.launch {
            transaksiRepository.addTransaksiBarang(trans, context, _imageUri.value!!).collect() {
                when (it) {
                    is Resource.Error -> setLoading(false)
                    is Resource.Loading -> setLoading(true)
                    is Resource.Success -> showDialog(true)
                }
            }
        }
    }

    fun donasiDanaSubmit(
        namaDonasi: String, donasiId: String, donasiType:
        String, relawan: String, idRelawan: String
    ) {
        val trans = Transaksi(
            donasiId = donasiId,
            transaksiId = UUID.randomUUID().toString(),
            donasiType = donasiType,
            title = namaDonasi,
            namaRelawan = relawan,
            namaMember = userRepository.currentUser!!.item!!.username,
            income = _dana.value.toLong(),
            tanggal = System.currentTimeMillis(),
            resi = "",
            status = "",
            ekspedisi = "",
            deskripsi = "",
            metodePembayaran = _metode.value,
            gambar = "",
            idMember = userId,
            idRelawan = idRelawan
        )

        viewModelScope.launch {
            transaksiRepository.addTransaksiDana(trans).collect {
                when (it) {
                    is Resource.Error -> setLoading(false)
                    is Resource.Loading -> setLoading(true)
                    is Resource.Success -> {
                        updateUserSaldo(trans.income, donasiId)
                    }
                }
            }
        }
    }

    private fun updateDonasiGain(donasiId: String, value: Long) {
        viewModelScope.launch {
            donasiRepository.updateDonasiGain(donasiId, value).collect {
                when (it) {
                    is Resource.Error -> {
                        setLoading(false)
                        Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                    }

                    is Resource.Loading -> setLoading(true)
                    is Resource.Success -> {
                        setLoading(false)
                        showDialog(true)
                    }
                }
            }
        }
    }

    private fun updateUserSaldo(value: Long, donasiId: String) {
        viewModelScope.launch {
            userRepository.updateSaldo(value).collect {
                when (it) {
                    is Resource.Error -> {
                        setLoading(false)
                        Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                    }

                    is Resource.Loading -> setLoading(true)
                    is Resource.Success -> {
                        setLoading(true)
                        updateDonasiGain(donasiId, value)
                    }
                }
            }
        }
    }
}