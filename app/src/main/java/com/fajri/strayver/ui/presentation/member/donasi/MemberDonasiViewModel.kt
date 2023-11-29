package com.fajri.strayver.ui.presentation.member.donasi

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.model.DonasiModelResponse
import com.fajri.strayver.data.repository.DonasiRepository
import com.fajri.strayver.data.repository.UserRepository
import com.fajri.strayver.model.UserData
import com.fajri.strayver.util.TipeDonasi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemberDonasiViewModel @Inject constructor(
    private val donasiRepository: DonasiRepository,
    private val userRepository: UserRepository
): ViewModel() {

    private val _currTabIndex= mutableIntStateOf(0)
    val currTabIndex: State<Int> = _currTabIndex

    private val _type= mutableStateOf(TipeDonasi.DANA)
    val type: State<String> = _type

    private val _search= mutableStateOf("")
    val search: State<String> = _search

    private val _isLoading= mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _donasi = mutableStateOf<List<DonasiModelResponse>>(emptyList())
    val donasi: State<List<DonasiModelResponse>> = _donasi

    private val _relawanData= mutableStateOf(UserData())
    val relawanData: State<UserData> = _relawanData

    fun setLoading(state: Boolean) {
        _isLoading.value= state
    }

    fun setIndex(index: Int) {
        _currTabIndex.intValue= index
    }

    fun setType(type: String) {
        _type.value= type
    }

    fun onChangeSearch(value: String) {
        _search.value= value
    }

    fun getDonasiByCategory() {
        viewModelScope.launch {
            donasiRepository.getDonasiByCategory(_type.value).collect {
                when(it) {
                    is Resource.Error -> setLoading(false)
                    is Resource.Loading -> setLoading(true)
                    is Resource.Success -> {
                        _donasi.value= it.data!!
                        setLoading(false)
                    }
                }
            }
        }
    }

    fun searchQuery() {
        viewModelScope.launch {
            donasiRepository.donasiSearchQuery(_search.value).collect {
                when(it) {
                    is Resource.Error -> setLoading(false)
                    is Resource.Loading -> setLoading(true)
                    is Resource.Success -> {
                        _donasi.value= it.data!!
                        setLoading(false)
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
}