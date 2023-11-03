package com.fajri.strayver.ui.presentation.member.home

import androidx.lifecycle.ViewModel
import com.fajri.strayver.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MemberHomeViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {


}