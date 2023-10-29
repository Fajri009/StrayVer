package com.fajri.strayver.ui.presentation.lupaSandi

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.fajri.strayver.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LupaSandiViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _email: MutableState<String> = mutableStateOf("")
    val email: State<String> = _email

    private val _isShowDialog: MutableState<Boolean> = mutableStateOf(false)
    val isShowDialog: State<Boolean> = _isShowDialog

    fun onChangeEmail(value: String) {
        _email.value = value
    }

    fun setDialog(show: Boolean) {
        _isShowDialog.value = show
    }

    fun onSubmit(context: Context) {
        if (_email.value.isEmpty()) {
            Toast.makeText(context, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show()
        } else {
            userRepository.resetPassword(_email.value, _isShowDialog, context)
            if (_isShowDialog.value) {
                setDialog(true)
            }
        }
    }
}