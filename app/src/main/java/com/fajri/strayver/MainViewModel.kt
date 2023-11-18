package com.fajri.strayver

import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.repository.OnBoardRepository
import com.fajri.strayver.data.repository.UserRepository
import com.fajri.strayver.util.Route
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: OnBoardRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private val _userRole= mutableStateOf("")
    val userRole: State<String> = _userRole

    fun formatLongWithDots(value: Long): String {
        val stringValue = value.toString()
        val length = stringValue.length

        if (length <= 3) {
            return stringValue
        }

        val formatted = StringBuilder()
        var dotCount = 0

        for (i in length - 1 downTo 0) {
            formatted.append(stringValue[i])

            if (++dotCount == 3 && i > 0) {
                formatted.append('.')
                dotCount = 0
            }
        }
        return formatted.reverse().toString()
    }

    fun getRole() {
        viewModelScope.launch {
            userRepository.getUserRole().collect {
                when (it) {
                    is Resource.Success ->  {
                        _userRole.value= it.data!!
                    }
                    else -> Unit
                }
            }
        }
    }
}