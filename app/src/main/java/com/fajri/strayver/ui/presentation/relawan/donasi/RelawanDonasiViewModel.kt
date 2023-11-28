package com.fajri.strayver.ui.presentation.relawan.donasi

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.model.DonasiModelResponse
import com.fajri.strayver.data.repository.DonasiRepository
import com.fajri.strayver.data.repository.UserRepository
import com.fajri.strayver.util.TipeDonasi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RelawanDonasiViewModel @Inject constructor(
    private val donasiRepository: DonasiRepository,
    private val userRepository: UserRepository
): ViewModel() {
    private val _search = mutableStateOf("")
    val search: State<String> = _search

    private val _currentTabIndex = mutableIntStateOf(0)
    val currentTabIndex: State<Int> = _currentTabIndex

    private val _tipeDonasi = mutableStateOf(TipeDonasi.DANA)
    val tipeDonasi: State<String> = _tipeDonasi

    private val _donasiData = mutableStateOf<List<DonasiModelResponse>>(emptyList())
    val donasiData: State<List<DonasiModelResponse>> = _donasiData

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun onChangeSearch(value: String) {
        _search.value = value
    }

    fun setIndex(index: Int) {
        _currentTabIndex.intValue = index
    }

    fun setTipeDonasi(tipeDonasi: String) {
        _tipeDonasi.value = tipeDonasi
    }

    fun searchQuery() {
        viewModelScope.launch {
            donasiRepository.donasiSearchQuery(_search.value).collect {
                when (it) {
                    is Resource.Loading -> {
                        _isLoading.value  = true
                    }
                    is Resource.Success -> {
                        _donasiData.value = it.data!!
                        _isLoading.value = false
                    }
                    is Resource.Error -> {
                        _isLoading.value = false
                    }
                }
            }
        }
    }

    fun getDonasiByUserIdAndCategory() {
        viewModelScope.launch {
            donasiRepository.getDonasiByUserIdAndCategory(userRepository.user!!.uid, _tipeDonasi.value).collect {
                when (it) {
                    is Resource.Loading -> {
                        _isLoading.value  = true
                    }
                    is Resource.Success -> {
                        _donasiData.value = it.data!!
                        _isLoading.value = false
                    }
                    is Resource.Error -> {
                        _isLoading.value = false
                    }
                }
            }
        }
    }
}