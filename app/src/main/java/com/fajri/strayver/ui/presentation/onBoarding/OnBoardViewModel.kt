package com.fajri.strayver.ui.presentation.onBoarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.OnBoardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardViewModel @Inject constructor (
    private val repository: OnBoardRepository
): ViewModel() {

    fun setOnBoardingCompleted() {
        viewModelScope.launch {
            repository.setCompleted()
        }
    }
}