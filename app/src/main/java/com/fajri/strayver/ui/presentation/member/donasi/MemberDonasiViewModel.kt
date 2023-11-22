package com.fajri.strayver.ui.presentation.member.donasi

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import com.fajri.strayver.data.repository.DonasiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MemberDonasiViewModel @Inject constructor(
    private val donasiRepository: DonasiRepository
): ViewModel() {

    private val _currTabIndex= mutableIntStateOf(0)
    val currTabIndex: State<Int> = _currTabIndex

    fun setIndex(index: Int) {
        _currTabIndex.intValue= index
    }
}