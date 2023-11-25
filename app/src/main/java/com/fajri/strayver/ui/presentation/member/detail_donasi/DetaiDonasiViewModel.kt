package com.fajri.strayver.ui.presentation.member.detail_donasi

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.repository.DonasiRepository
import com.fajri.strayver.model.Donasi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetaiDonasiViewModel @Inject constructor(
    private val donasiRepository: DonasiRepository
): ViewModel() {

    private val _donasi= mutableStateOf(Donasi())
    val donasi: State<Donasi> = _donasi

    private val _isLoading= mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun getDonasiDetail(id: String) =
        viewModelScope.launch {
            donasiRepository.getDonasiById(id).collect {
                when(it) {
                    is Resource.Error -> setLoading(false)
                    is Resource.Loading -> setLoading(true)
                    is Resource.Success -> {
                        _donasi.value= it.data!!.item!!
                        setLoading(false)
                    }
                }
            }
        }

    fun setLoading(state: Boolean) {
        _isLoading.value= state
    }
}