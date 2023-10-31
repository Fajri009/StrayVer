package com.fajri.strayver.ui.presentation.splash

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.repository.OnBoardRepository
import com.fajri.strayver.util.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val onBoardRepository: OnBoardRepository
): ViewModel() {

    private val _nextDestination: MutableState<String> = mutableStateOf(Route.ONBOARD)
    val nextDestination: State<String> = _nextDestination

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    fun changeLoadingState(state: Boolean) {
        _isLoading.value= state
    }

    init {
        viewModelScope.launch {
            onBoardRepository.isCompleted.collect { isComplete ->
                if (isComplete) {
                    _nextDestination.value = Route.LOGIN
                } else {
                    _nextDestination.value= Route.ONBOARD
                }

                _isLoading.value= false
            }
        }
    }
}