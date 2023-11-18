package com.fajri.strayver.ui.presentation.member.profil

import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.model.UserModelResponse
import com.fajri.strayver.data.repository.UserRepository
import com.fajri.strayver.model.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemberProfilViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {

    private val _userData= mutableStateOf(UserModelResponse())
    val userData: State<UserModelResponse> = _userData

    private val _isLoading= mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading
    fun getUser() {
        viewModelScope.launch {
            userRepository.getUserById("dawdawda").collect {
                when(it) {
                    is Resource.Loading -> {
                        _isLoading.value= true
                    }
                    is Resource.Success -> {
                        _userData.value= it.data!!
                        _isLoading.value= false
                    }
                    is Resource.Error -> {
                        UserModelResponse(item = null, key = null)
                        _isLoading.value= false

                    }
                }
            }
        }
    }

    fun logout() {

    }
}