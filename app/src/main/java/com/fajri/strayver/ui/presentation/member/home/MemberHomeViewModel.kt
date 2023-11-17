package com.fajri.strayver.ui.presentation.member.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.model.ArtikelModelResponse
import com.fajri.strayver.data.repository.DatabaseRepository
import com.fajri.strayver.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemberHomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val databaseRepository: DatabaseRepository
) : ViewModel() {

    private val _artikel = mutableStateOf<List<ArtikelModelResponse>>(emptyList())
    val artikel: State<List<ArtikelModelResponse>> = _artikel

    private val _artikelLoading= mutableStateOf(false)
    val artikelLoading: State<Boolean> = _artikelLoading

    fun getArtikel() {
        viewModelScope.launch {
            databaseRepository.getArtikel().collect {
                when(it) {
                    is Resource.Loading -> {
                        _artikelLoading.value= true
                    }
                    is Resource.Success -> {
                        _artikel.value= it.data!!
                        _artikelLoading.value= false
                    }
                    is Resource.Error -> {
                        val dor= "dada"
                    }
                }
            }
        }
    }
}