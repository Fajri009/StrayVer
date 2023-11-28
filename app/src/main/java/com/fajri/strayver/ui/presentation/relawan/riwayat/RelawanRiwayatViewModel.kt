package com.fajri.strayver.ui.presentation.relawan.riwayat

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.fajri.strayver.data.model.DonasiModelResponse
import com.fajri.strayver.data.repository.DonasiRepository
import com.fajri.strayver.util.TipeDonasi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RelawanRiwayatViewModel @Inject constructor(
    donasiRepository: DonasiRepository
): ViewModel() {
    private val _currentTabIndex = mutableStateOf(0)
    val currentTabIndex: State<Int> = _currentTabIndex

    private val _tipeDonasi = mutableStateOf("Semua")
    val tipeDonasi: State<String> = _tipeDonasi

    private val _donasiData = mutableStateOf<List<DonasiModelResponse>>(emptyList())
    val donasiData: State<List<DonasiModelResponse>> = _donasiData

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun setIndex(index: Int) {
        _currentTabIndex.value = index
    }

    fun setTipeDonasi(tipeDonasi: String) {
        _tipeDonasi.value = tipeDonasi
    }

    fun getDonasiBy() {
        
    }
}