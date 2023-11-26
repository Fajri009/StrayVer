package com.fajri.strayver

import com.fajri.strayver.data.repository.OnBoardRepository
import com.fajri.strayver.data.repository.UserRepository
import com.fajri.strayver.ui.presentation.login.LoginViewModel
import io.mockk.MockKAnnotations
import io.mockk.MockKAnnotations.init
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class LoginViewModelTest {

    private lateinit var viewModel: LoginViewModel

    @MockK
    private lateinit var userRepository: UserRepository

    @MockK
    private lateinit var repository: OnBoardRepository

    @Before
    fun setUp() {
        init(this)
        viewModel= LoginViewModel(repository, userRepository)
    }

    @Test
    fun `should return success when login`() {
        viewModel.onSubmit()
    }
}