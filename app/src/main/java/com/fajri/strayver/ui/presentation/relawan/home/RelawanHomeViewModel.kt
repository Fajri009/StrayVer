package com.fajri.strayver.ui.presentation.relawan.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.model.DonasiModelResponse
import com.fajri.strayver.data.model.UserModelResponse
import com.fajri.strayver.data.repository.DonasiRepository
import com.fajri.strayver.data.repository.UserRepository
import com.fajri.strayver.util.TipeDonasi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class RelawanHomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val donasiRepository: DonasiRepository
): ViewModel() {
    private val _userData = mutableStateOf(UserModelResponse())
    val userData: State<UserModelResponse> = _userData

    private val _donasiData = mutableStateOf<List<DonasiModelResponse>>(emptyList())
    val donasiData: State<List<DonasiModelResponse>> = _donasiData

    private val _donasiDataDana = mutableStateOf<List<DonasiModelResponse>>(emptyList())
//    val donasiDataDana: State<List<DonasiModelResponse>> = _donasiDataDana

    private val _donasiDataBarang = mutableStateOf<List<DonasiModelResponse>>(emptyList())
//    val donasiDataBarang: State<List<DonasiModelResponse>> = _donasiDataBarang

    private val _totalDana = mutableStateOf(0L)
    val totalDana: State<Long> = _totalDana

    private val _totalBarang = mutableStateOf(0L)
    val totalBarang: State<Long> = _totalBarang

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun getUser() {
        viewModelScope.launch {
            userRepository.getUserById().collect {
                when (it) {
                    is Resource.Loading -> {
                        _isLoading.value = true
                    }
                    is Resource.Success -> {
                        _userData.value = it.data!!
                        _isLoading.value = false
                    }
                    is Resource.Error -> {
                        UserModelResponse(item = null, key = null)
                        _isLoading.value = false
                    }
                }
            }
        }
    }

    fun getDonasiByUserId() {
        viewModelScope.launch {
            donasiRepository.getDonasiByUserId(userRepository.user!!.uid).collect {
                when (it) {
                    is Resource.Loading -> {
                        _isLoading.value = true
                    }
                    is Resource.Success -> {
                        _donasiData.value = it.data!!
                        _isLoading.value = false
                    }
                    is Resource.Error -> {
                        DonasiModelResponse(item = null, key = null)
                        _isLoading.value = false
                    }
                }
            }
        }
    }

    fun getDonasiByUserIdAndCategoryDana() {
        viewModelScope.launch {
            donasiRepository.getDonasiByUserIdAndCategory(userRepository.user!!.uid, TipeDonasi.DANA).collect {
                when (it) {
                    is Resource.Loading -> {
                        _isLoading.value  = true
                    }
                    is Resource.Success -> {
                        _donasiDataDana.value = it.data!!
                        totalDonasiDana()
                        _isLoading.value = false
                    }
                    is Resource.Error -> {
                        _isLoading.value = false
                    }
                }
            }
        }
    }
    fun getDonasiByUserIdAndCategoryBarang() {
        viewModelScope.launch {
            donasiRepository.getDonasiByUserIdAndCategory(userRepository.user!!.uid, TipeDonasi.BARANG).collect {
                when (it) {
                    is Resource.Loading -> {
                        _isLoading.value  = true
                    }
                    is Resource.Success -> {
                        _donasiDataBarang.value = it.data!!
                        totalDonasiBarang()
                        _isLoading.value = false
                    }
                    is Resource.Error -> {
                        _isLoading.value = false
                    }
                }
            }
        }
    }

    fun totalDonasiDana() {
        var result: Long = 0L

        _donasiDataDana.value.forEach {
            result += it.item?.donasiGain ?: 0
        }

        _totalDana.value = result
    }


    fun totalDonasiBarang() {
        var result: Long = 0L

        _donasiDataBarang.value.forEach {
            result += it.item?.donasiGain ?: 0
        }

        _totalBarang.value = result
    }
}