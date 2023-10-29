package com.fajri.strayver

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.repository.OnBoardRepository
import com.fajri.strayver.util.Route
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: OnBoardRepository
) : ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String> = mutableStateOf(Route.ONBOARD)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            repository.isCompleted.collect { isComplete ->
                if (isComplete) {
                    _startDestination.value = Route.LOGIN
                } else {
                    _startDestination.value= Route.ONBOARD
                }

                _isLoading.value= false
            }
        }
    }
}