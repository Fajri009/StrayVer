package com.fajri.strayver.ui.presentation.member.riwayat

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.model.TransaksiModelResponse
import com.fajri.strayver.data.repository.DonasiRepository
import com.fajri.strayver.data.repository.TransaksiRepository
import com.fajri.strayver.data.repository.UserRepository
import com.fajri.strayver.util.TipeDonasi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemberRiwayatViewModel @Inject constructor(
    private val transaksiRepository: TransaksiRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private val _currTabIndex = mutableIntStateOf(0)
    val currTabIndex: State<Int> = _currTabIndex

    private val _transaksi = mutableStateOf<List<TransaksiModelResponse>>(emptyList())
    val transaksi: State<List<TransaksiModelResponse>> = _transaksi

    private val _type = mutableStateOf("Semua")
    val type: State<String> = _type

    private val _search = mutableStateOf("")
    val search: State<String> = _search

    fun setIndex(index: Int) {
        _currTabIndex.intValue = index
    }

    fun onChangeSearch(value: String) {
        _search.value = value
    }

    fun setType(type: String) {
        _type.value = type
    }

    fun getUserTransaksi() {
        viewModelScope.launch {
            transaksiRepository.getTransaksi(
                userRepository.user!!.uid,
                _type.value
            )
                .collect {
                    when (it) {
                        is Resource.Error -> {}
                        is Resource.Loading -> {}
                        is Resource.Success -> _transaksi.value = it.data!!
                    }
                }
        }
    }

    fun searchQuery() {
        viewModelScope.launch {
            transaksiRepository.transaksiSearchQuery(_search.value, userRepository.user!!.uid)
                .collect {
                    when (it) {
                        is Resource.Error -> {}
                        is Resource.Loading -> {}
                        is Resource.Success -> _transaksi.value = it.data!!
                    }
                }
        }
    }
}