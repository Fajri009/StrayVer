package com.fajri.strayver.ui.presentation.relawan.donasi

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.model.DonasiModelResponse
import com.fajri.strayver.data.repository.DonasiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RelawanDonasiViewModel @Inject constructor(
    private val donasiRepository: DonasiRepository
): ViewModel() {
    private val _currentTabIndex = mutableIntStateOf(0)
    val currentTabIndex: State<Int> = _currentTabIndex

    private val _donasiData = mutableStateOf<List<DonasiModelResponse>>(emptyList())
    val donasiData: State<List<DonasiModelResponse>> = _donasiData

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun setIndex(index: Int) {
        _currentTabIndex.intValue = index
    }

    fun getDonasi() {
        viewModelScope.launch {
            donasiRepository.getAllDonasi().collect {
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
}