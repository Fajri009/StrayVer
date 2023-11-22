package com.fajri.strayver.ui.presentation.member.edit_profil.component

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.data.Resource
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.presentation.component.CustomTextField
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.ButtonType
import com.fajri.strayver.util.Route
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun EditProfilContent(viewModel: EditProfilMemberViewModel, scope: CoroutineScope, navController: NavController) {

    val context= LocalContext.current

    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(top = 180.dp)
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Shades50)
            .padding(top = 70.dp, start = 20.dp, end = 20.dp, bottom = 80.dp)
    ) {

        item {
            Text(text = "Nama Lengkap", style = Type.textSmMedium())
            CustomTextField(
                text = viewModel.nama.value,
                placeholder = "",
                onValueChange = {
                    viewModel.onChangeNama(it)
                })
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Text(text = "Username", style = Type.textSmMedium())
            CustomTextField(
                text = viewModel.username.value,
                placeholder = "",
                onValueChange = {
                    viewModel.onChangeUsername(it)
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Text(text = "Email", style = Type.textSmMedium())
            CustomTextField(
                text = viewModel.email.value,
                placeholder = "",
                onValueChange = {
                    viewModel.onChangeEmail(it)
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Text(text = "Alamat", style = Type.textSmMedium())
            CustomTextField(
                text = viewModel.alamat.value,
                placeholder = "",
                onValueChange = {
                    viewModel.onChangeAlamat(it)
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Text(text = "Nomer Telepon", style = Type.textSmMedium())
            CustomTextField(
                text = viewModel.telp.value,
                placeholder = "",
                onValueChange = {
                    viewModel.onChangeTelp(it)
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Text(text = "Password", style = Type.textSmMedium())
            CustomTextField(
                text = viewModel.password.value,
                placeholder = "",
                onValueChange = {
                    viewModel.onChangePassword(it)
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            CustomButton(
                onClick = {
                    scope.launch {
                        viewModel.updateProfil().collect {
                            when(it) {
                                is Resource.Success -> {
                                    viewModel.getUserData()
                                    viewModel.onChangeLoadingState(false)
                                    navController.navigate(Route.MEMBER_PROFIL)
                                }
                                is Resource.Loading -> {
                                    viewModel.onChangeLoadingState(true)
                                }
                                is Resource.Error -> {
                                    viewModel.onChangeLoadingState(false)
                                    Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    }
                },
                text = "Simpan",
                type = ButtonType.LARGE
            )
        }
    }
}