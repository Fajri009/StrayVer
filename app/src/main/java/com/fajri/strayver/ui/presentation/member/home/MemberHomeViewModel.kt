package com.fajri.strayver.ui.presentation.member.home

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.model.ArtikelModelResponse
import com.fajri.strayver.data.model.DonasiModelResponse
import com.fajri.strayver.data.model.UserModelResponse
import com.fajri.strayver.data.repository.DatabaseRepository
import com.fajri.strayver.data.repository.DonasiRepository
import com.fajri.strayver.data.repository.UserRepository
import com.fajri.strayver.model.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemberHomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val databaseRepository: DatabaseRepository,
    private val donasiRepository: DonasiRepository
) : ViewModel() {

    private val _donasi = mutableStateOf<List<DonasiModelResponse>>(emptyList())
    val donasi: State<List<DonasiModelResponse>> = _donasi

    private val _donasiLoading= mutableStateOf(false)
    val donasiLoading: State<Boolean> = _donasiLoading

    private val _artikel = mutableStateOf<List<ArtikelModelResponse>>(emptyList())
    val artikel: State<List<ArtikelModelResponse>> = _artikel

    private val _artikelLoading= mutableStateOf(false)
    val artikelLoading: State<Boolean> = _artikelLoading

    private val _userData= mutableStateOf(UserModelResponse())
    val userData: State<UserModelResponse> = _userData

    private val _relawanData= mutableStateOf(UserData())
    val relawanData: State<UserData> = _relawanData

    fun getArtikel(context: Context) {
        viewModelScope.launch {
            databaseRepository.getArtikel().collect {
                when(it) {
                    is Resource.Loading -> {
                        _artikelLoading.value= true
                    }
                    is Resource.Success -> {
                        _artikel.value= it.data!!
                        _artikelLoading.value= false
                    }
                    is Resource.Error -> {
                        Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                        _artikelLoading.value= false
                    }
                }
            }
        }
    }

    fun getUser() {
        viewModelScope.launch {
            userRepository.getUserById().collect {
                when(it) {
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        _userData.value= it.data!!
                    }
                    is Resource.Error -> {
                        UserModelResponse(item = null, key = null)
                    }
                }
            }
        }
    }

    fun getDonasi() {
        viewModelScope.launch {
            donasiRepository.getAllDonasi().collect {
                when(it) {
                    is Resource.Loading -> {
                        _donasiLoading.value= true
                    }
                    is Resource.Success -> {
                        _donasi.value= it.data!!
                        _donasiLoading.value= false
                    }
                    is Resource.Error -> {
                        _donasiLoading.value= false
                    }
                }
            }
        }
    }

    fun getRelawanData(userId: String) {
        viewModelScope.launch {
            userRepository.getUserById(userId).collect {
                when(it) {
                    is Resource.Loading -> {
                        _donasiLoading.value= true
                    }
                    is Resource.Success -> {
                        _relawanData.value= it.data!!.item!!
                        _donasiLoading.value= false
                    }
                    is Resource.Error -> {
                        _donasiLoading.value= false
                    }
                }
            }
        }
    }
}