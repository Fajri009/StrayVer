package com.fajri.strayver.ui.presentation.component.detailRiwayat

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.model.TransaksiModelResponse
import com.fajri.strayver.data.repository.OnBoardRepository
import com.fajri.strayver.data.repository.TransaksiRepository
import com.fajri.strayver.model.Transaksi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailRiwayatViewModel @Inject constructor(
    private val transaksiRepository: TransaksiRepository,
    private val onBoardRepository: OnBoardRepository
): ViewModel() {

    private val _transaksi= mutableStateOf<Transaksi>(Transaksi())
    val transaksi: State<Transaksi> = _transaksi

    private val _isLoading= mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _role= mutableStateOf("")
    val role: State<String> = _role

    fun setLoading(state: Boolean) {
        _isLoading.value= state
    }

    fun getTransaksiById(transaksiId: String) {
        viewModelScope.launch {
                transaksiRepository.getTransaksiById(transaksiId).collect {
                    when(it) {
                        is Resource.Error -> setLoading(false)
                        is Resource.Loading -> setLoading(true)
                        is Resource.Success -> {
                            _transaksi.value= it.data!!.item!!
                            setLoading(false)
                        }
                    }
                }
        }
    }

    fun getRole() {
        viewModelScope.launch {
            onBoardRepository.getRole.collect {
                _role.value= it
            }
        }
    }
}