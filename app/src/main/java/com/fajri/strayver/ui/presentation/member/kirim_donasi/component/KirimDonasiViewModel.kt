package com.fajri.strayver.ui.presentation.member.kirim_donasi.component

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.fajri.strayver.data.repository.DonasiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KirimDonasiViewModel @Inject constructor(
    private val donasiRepository: DonasiRepository
): ViewModel(){

    private val _imageUri= mutableStateOf<Uri?>(null)
    val imageUri: State<Uri?> = _imageUri

    private val _isLoading= mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun setImageUri(uri: Uri) {
        _imageUri.value= uri
    }

    fun setLoading(state: Boolean) {
        _isLoading.value= state
    }

    fun onUploadFile(context: Context){}

}