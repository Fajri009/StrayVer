package com.fajri.strayver.ui.presentation.member.detail_donasi

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.repository.DonasiRepository
import com.fajri.strayver.data.repository.UserRepository
import com.fajri.strayver.model.Donasi
import com.fajri.strayver.model.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetaiDonasiViewModel @Inject constructor(
    private val donasiRepository: DonasiRepository,
    private val userRepository: UserRepository
): ViewModel() {

    private val _donasi= mutableStateOf(Donasi())
    val donasi: State<Donasi> = _donasi

    private val _isLoading= mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _isShowDialog= mutableStateOf(false)
    val isShowDialog: State<Boolean> = _isShowDialog

    private val _relawanData= mutableStateOf(UserData())
    val relawanData: State<UserData> = _relawanData

    fun getDonasiDetail(id: String) =
        viewModelScope.launch {
            donasiRepository.getDonasiById(id).collect {
                when(it) {
                    is Resource.Error -> setLoading(false)
                    is Resource.Loading -> setLoading(true)
                    is Resource.Success -> {
                        _donasi.value= it.data!!.item!!
                        getRelawanData(_donasi.value.userId)
                        setLoading(false)
                    }
                }
            }
        }

    fun getRelawanData(userId: String) {
        viewModelScope.launch {
            userRepository.getUserById(userId).collect {
                when(it) {
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        _relawanData.value= it.data!!.item!!
                    }
                    is Resource.Error -> {
                    }
                }
            }
        }
    }

    fun setLoading(state: Boolean) {
        _isLoading.value= state
    }

    fun setDialog(state: Boolean) {
        _isShowDialog.value= state
    }
}