package com.fajri.strayver

import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.repository.OnBoardRepository
import com.fajri.strayver.data.repository.UserRepository
import com.fajri.strayver.model.UserData
import com.fajri.strayver.ui.presentation.register.RegisterViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RegisterViewModelTest {

    private lateinit var viewModel: RegisterViewModel

    @MockK
    private lateinit var onBoardRepository: OnBoardRepository

    @MockK
    private lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel= RegisterViewModel(onBoardRepository, userRepository)
    }

    @Test
    fun `should return success when register success`()= runBlocking {

        val nama= "Muhammad Syafi Islam"
        val username= "syf12"
        val email= "syafi@gmail.com"
        val telp= "0812345678"
        val alamat= "Tanjung Priok"
        val password= "123456"
        val role= "member"
        val saldo: Long= 45000000

        viewModel.onChangeNama(nama)
        viewModel.onChangeUsername(username)
        viewModel.onChangeEmail(email)
        viewModel.onChangeTelp(telp)
        viewModel.onChangeAlamat(alamat)
        viewModel.onChangePassword(password)

        val user = UserData(
            nama = nama,
            username = username,
            email = email,
            telp = telp,
            alamat = alamat,
            password = password,
            role = role,
            saldo = saldo,
        )

        coEvery {
            userRepository.registerUser(user)
        } returns flow {
            emit(Resource.Success("Berhasil membuat akun"))
        }

        val result= viewModel.onSubmit().toList()

        coVerify {
            userRepository.registerUser(user)
        }

        assertThat(viewModel.email.value).isEqualTo(email)
        assertThat(viewModel.username.value).isEqualTo(username)
        assertThat(viewModel.email.value).isEqualTo(email)
        assertThat(viewModel.telp.value).isEqualTo(telp)
        assertThat(viewModel.alamat.value).isEqualTo(alamat)
        assertThat(viewModel.password.value).isEqualTo(password)
        assertThat(result[0]).isInstanceOf(Resource.Success::class.java)
        assertThat(result[0].data).isEqualTo("Berhasil membuat akun")
    }
}