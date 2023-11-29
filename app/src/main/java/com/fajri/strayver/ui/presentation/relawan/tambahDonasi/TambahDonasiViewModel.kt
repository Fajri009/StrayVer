package com.fajri.strayver.ui.presentation.relawan.tambahDonasi

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.model.DonasiModelResponse
import com.fajri.strayver.data.model.TransaksiModelResponse
import com.fajri.strayver.data.repository.DonasiRepository
import com.fajri.strayver.data.repository.TransaksiRepository
import com.fajri.strayver.model.Donasi
import com.fajri.strayver.model.Transaksi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TambahDonasiViewModel @Inject constructor(
    private val donasiRepository: DonasiRepository,
    private val transaksiRepository: TransaksiRepository
): ViewModel() {
    private val _donasiData = mutableStateOf(Donasi())
    val donasiData: State<Donasi> = _donasiData

    private val _transaksiData = mutableStateOf<List<TransaksiModelResponse>>(emptyList())
    val transaksiData: State<List<TransaksiModelResponse>> = _transaksiData

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun setLoading(value: Boolean) {
        _isLoading.value = value
    }

    fun getDonasiById(donasiId: String) {
        viewModelScope.launch {
            donasiRepository.getDonasiById(donasiId).collect {
                when (it) {
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

    fun getTransaksiByIdDonasi(donasiId: String) {
        viewModelScope.launch {
            transaksiRepository.getTransaksiByIdDonasi(donasiId).collect {
                when (it) {
                    is Resource.Loading -> {
                        setLoading(true)
                    }
                    is Resource.Success -> {
                        _transaksiData.value = it.data!!
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