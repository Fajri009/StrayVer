package com.fajri.strayver

import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.repository.OnBoardRepository
import com.fajri.strayver.util.Route
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: OnBoardRepository
) : ViewModel() {

    private var _userRole= mutableStateOf("")
    var userRole: State<String> = _userRole

    fun getRole() {
        viewModelScope.launch {
            repository.getRole.map {  role ->
                _userRole.value= role
            }
        }
    }
}