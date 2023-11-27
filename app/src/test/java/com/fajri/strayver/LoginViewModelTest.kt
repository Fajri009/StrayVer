//package com.fajri.strayver
//
//import com.fajri.strayver.data.Resource
//import com.fajri.strayver.data.repository.OnBoardRepository
//import com.fajri.strayver.data.repository.UserRepository
//import com.fajri.strayver.ui.presentation.login.LoginViewModel
//import com.google.common.truth.Truth.assertThat
//import io.mockk.MockKAnnotations
//import io.mockk.coEvery
//import io.mockk.coVerify
//import io.mockk.impl.annotations.MockK
//import io.mockk.impl.annotations.RelaxedMockK
//import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.flow.toList
//import kotlinx.coroutines.runBlocking
//import org.hamcrest.MatcherAssert.assertThat
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.junit.runners.JUnit4
//
//@RunWith(JUnit4::class)
//class LoginViewModelTest {
//
//    private lateinit var viewModel: LoginViewModel
//
//    @RelaxedMockK
//    private lateinit var onBoardRepository: OnBoardRepository
//
//    @MockK
//    private lateinit var userRepository: UserRepository
//
//    @Before
//    fun setUp() {
//        MockKAnnotations.init(this)
//        viewModel = LoginViewModel(onBoardRepository, userRepository)
//    }
//
//    @Test
//    fun `should return success when login success`() = runBlocking {
//        //Parameter Given
//        val email = "abdul@gmail.com"
//        val password = "12345678"
//
//        viewModel.onChangeEmail(value = email)
//        viewModel.onChangePassword(value = password)
//
//        //Mock Behavior
//        coEvery {
//            userRepository.login(email = email, password = password)
//        } returns flow { emit(Resource.Success(data = "Berhasi Login")) }
//
//        //Action
//        val result = viewModel.onSubmit().toList()
//
//        //Verify Mock
//        coVerify { userRepository.login(email = email, password = password) }
//
//        //Assertion
//        assertThat(viewModel.email.value).isEqualTo(email)
//        assertThat(viewModel.sandi.value).isEqualTo(password)
//        assertThat(result[0]).isInstanceOf(Resource.Success::class.java)
//        assertThat(result[0].data).isEqualTo("Berhasi Login")
//    }
//
//
//}