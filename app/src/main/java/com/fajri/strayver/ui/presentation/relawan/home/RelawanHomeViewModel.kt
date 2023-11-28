package com.fajri.strayver.ui.presentation.relawan.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.model.DonasiModelResponse
import com.fajri.strayver.data.model.UserModelResponse
import com.fajri.strayver.data.repository.DonasiRepository
import com.fajri.strayver.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RelawanHomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val donasiRepository: DonasiRepository
): ViewModel() {
    private val _userData = mutableStateOf(UserModelResponse())
    val userData: State<UserModelResponse> = _userData

    private val _donasiData = mutableStateOf<List<DonasiModelResponse>>(emptyList())
    val donasiData: State<List<DonasiModelResponse>> = _donasiData

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
}