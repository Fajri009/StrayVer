package com.fajri.strayver.ui.presentation.member.kirim_donasi

import androidx.lifecycle.ViewModel
import com.fajri.strayver.data.repository.DonasiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KirimDonasiViewModel @Inject constructor(
    private val donasiRepository: DonasiRepository
):ViewModel() {

}