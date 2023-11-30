package com.fajri.strayver.ui.presentation.relawan.riwayat

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.model.DonasiModelResponse
import com.fajri.strayver.data.model.TransaksiModelResponse
import com.fajri.strayver.data.repository.DonasiRepository
import com.fajri.strayver.data.repository.TransaksiRepository
import com.fajri.strayver.data.repository.UserRepository
import com.fajri.strayver.model.UserData
import com.fajri.strayver.util.TipeDonasi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RelawanRiwayatViewModel @Inject constructor(
    private val transaksiRepository: TransaksiRepository,
    private val userRepository: UserRepository
): ViewModel() {
    private val _search = mutableStateOf("")
    val search: State<String> = _search

    private val _currentTabIndex = mutableStateOf(0)
    val currentTabIndex: State<Int> = _currentTabIndex

    private val _tipeDonasi = mutableStateOf("Semua")
    val tipeDonasi: State<String> = _tipeDonasi

    private val _transaksiData = mutableStateOf<List<TransaksiModelResponse>>(emptyList())
    val transaksiData: State<List<TransaksiModelResponse>> = _transaksiData

    private val _userData = mutableStateOf(UserData())
    val userData: State<UserData> = _userData

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun onChangeSearch(value: String) {
        _search.value = value
    }

    fun setIndex(index: Int) {
        _currentTabIndex.value = index
    }

    fun setTipeDonasi(tipeDonasi: String) {
        _tipeDonasi.value = tipeDonasi
    }

    fun getTransaksiByIdRelawan() {
        viewModelScope.launch {
            transaksiRepository.getTransaksiByIdRelawan(userRepository.user!!.uid, _tipeDonasi.value).collect {
                when (it) {
                    is Resource.Loading -> {
                        _isLoading.value  = true
                    }
                    is Resource.Success -> {
                        _transaksiData.value = it.data!!
                        _isLoading.value = false
                    }
                    is Resource.Error -> {
                        _isLoading.value = false
                    }
                }
            }
        }
    }

    fun getUserDataByUserId(userId: String) {
        viewModelScope.launch {
            userRepository.getUserById(userId).collect {
                when (it) {
                    is Resource.Error -> {}
                    is Resource.Loading -> {}
                    is Resource.Success -> _userData.value = it.data!!.item!!
                }
            }
        }
    }

    fun searchQuery() {
        viewModelScope.launch {
            transaksiRepository.transaksiSearchQueryByIdRelawan(_search.value, userRepository.user!!.uid)
                .collect {
                    when (it) {
                        is Resource.Error -> {}
                        is Resource.Loading -> {}
                        is Resource.Success -> _transaksiData.value = it.data!!
                    }
                }
        }
    }
}