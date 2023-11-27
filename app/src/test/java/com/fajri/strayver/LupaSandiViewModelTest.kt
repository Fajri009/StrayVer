package com.fajri.strayver

import com.fajri.strayver.data.Resource
import com.fajri.strayver.data.repository.OnBoardRepository
import com.fajri.strayver.data.repository.UserRepository
import com.fajri.strayver.ui.presentation.lupaSandi.LupaSandiViewModel
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class LupaSandiViewModelTest {
    private lateinit var viewModel: LupaSandiViewModel

//    @RelaxedMockK
//    private lateinit var onBoardRepository: OnBoardRepository

    @MockK
    private lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = LupaSandiViewModel(userRepository)
    }

    @Test
    fun `shold return success when lupa sandi success`() = runBlocking {
        // Parameter Given
        val email = "abdul@gmail.com"

        viewModel.onChangeEmail(email)

        // Mock Behavior
        coEvery {
            userRepository.resetPassword(email)
        } returns flow {
            emit(Resource.Success("Berhasil Mengirimkan Email"))
        }

        // Action
        val result = viewModel.onSubmit().toList()

        // Verify Mock
        coVerify {
            userRepository.resetPassword(email)
        }

        // Assertion
        assertThat(viewModel.email.value).isEqualTo(email)
        assertThat(result[0]).isInstanceOf(Resource.Success::class.java)
        assertThat(result[0].data).isEqualTo("Berhasil Mengirimkan Email")
    }
}