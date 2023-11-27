package com.fajri.strayver.ui.presentation.relawan.riwayat

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RelawanRiwayatViewModel @Inject constructor(

): ViewModel() {
    private val _currentTabIndex = mutableStateOf(0)
    val currentTabIndex: State<Int> = _currentTabIndex

    fun setIndex(index: Int) {
        _currentTabIndex.value = index
    }
}