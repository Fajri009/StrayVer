package com.fajri.strayver.ui.presentation.component.detailRiwayat

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.model.TransaksiModelResponse
import com.fajri.strayver.data.repository.DonasiRepository
import com.fajri.strayver.data.repository.OnBoardRepository
import com.fajri.strayver.data.repository.TransaksiRepository
import com.fajri.strayver.model.Donasi
import com.fajri.strayver.model.Transaksi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailRiwayatViewModel @Inject constructor(
    private val transaksiRepository: TransaksiRepository,
    private val donasiRepository: DonasiRepository,
    private val onBoardRepository: OnBoardRepository
): ViewModel() {

    private val _transaksi= mutableStateOf<Transaksi>(Transaksi())
    val transaksi: State<Transaksi> = _transaksi

    private val _donasiData = mutableStateOf(Donasi())
    val donasiData: State<Donasi> = _donasiData

    private val _isLoading= mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _role= mutableStateOf("")
    val role: State<String> = _role

    fun setLoading(state: Boolean) {
        _isLoading.value= state
    }

    fun getTransaksiById(transaksiId: String) {
        viewModelScope.launch {
                transaksiRepository.getTransaksiById(transaksiId).collect {
                    when(it) {
                        is Resource.Error -> setLoading(false)
                        is Resource.Loading -> setLoading(true)
                        is Resource.Success -> {
                            _transaksi.value= it.data!!.item!!
                            setLoading(false)
                        }
                    }
                }
        }
    }

    fun getRole() {
        viewModelScope.launch {
            onBoardRepository.getRole.collect {
                _role.value= it
            }
        }
    }

    fun setStatus(transaksiId: String) {
        viewModelScope.launch {
            transaksiRepository.updateStatus(transaksiId).collect {
                when(it) {
                    is Resource.Error -> setLoading(false)
                    is Resource.Loading -> setLoading(true)
                    is Resource.Success -> {
                        getTransaksiById(transaksiId)
                        setLoading(false)
                    }
                }
            }
        }
    }

    fun getDonasiById(donasiId: String) {
        viewModelScope.launch {
            donasiRepository.getDonasiById(donasiId).collect {
                when(it) {
                    is Resource.Loading -> {
                        setLoading(true)
                    }
                    is Resource.Success -> {
                        _donasiData.value = it.data!!.item!!
                        setLoading(false)
                    }
                    is Resource.Error -> {
                        setLoading(false)
                    }
                }
            }
        }
    }

    fun updateDonasiGain(donasiId: String, transaksiIncome: Long) {
//        val result = _donasiData.value.donasiGain + _transaksi.value.income
//        Log.i("cok", "${_donasiData.value.donasiGain} + ${_transaksi.value.income} = $result")
        viewModelScope.launch {
            donasiRepository.updateDonasiGain(donasiId, transaksiIncome).collect {
                when(it) {
                    is Resource.Loading -> {
                        setLoading(true)
                    }
                    is Resource.Success -> {
                        getDonasiById(_donasiData.value.donasiId)
                        setLoading(false)
                    }
                    is Resource.Error -> {
                        setLoading(false)
                    }
                }
            }
        }
    }
}