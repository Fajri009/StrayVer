package com.fajri.strayver.ui.presentation.register.component

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.presentation.component.CustomTextField
import com.fajri.strayver.ui.presentation.register.RegisterViewModel
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.ButtonType

@Composable
fun RegisterForm(viewModel: RegisterViewModel, navController: NavController, context: Context) {

    LazyColumn(
        Modifier
            .padding(top = 20.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Neutral50)
            .padding(20.dp)
    ) {

        item {
            Text(text = "Selamat Datang", style = Type.textLgBold(), color = Primary900)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Halo, bergabunglah dengan kami untuk memulai!",
                style = Type.textXsRegular()
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Nama Lengkap", style = Type.textSmMedium())
            CustomTextField(
                text = viewModel.nama.value,
                placeholder = "",
                onValueChange = {
                    viewModel.onChangeNama(it)
                }
            )
        }

        item {
            Spacer(modifier = Modifier.height(14.dp))
            Text(text = "Username", style = Type.textSmMedium())
            CustomTextField(
                text = viewModel.username.value,
                placeholder = "",
                onValueChange = {
                    viewModel.onChangeUsername(it)
                }
            )
        }

        item {
            Spacer(modifier = Modifier.height(14.dp))
            Text(text = "Email", style = Type.textSmMedium())
            CustomTextField(
                text = viewModel.email.value,
                placeholder = "",
                onValueChange = {
                    viewModel.onChangeEmail(it)
                }
            )
        }

        item {
            Spacer(modifier = Modifier.height(14.dp))
            Text(text = "Nomor Telepon", style = Type.textSmMedium())
            CustomTextField(
                text = viewModel.telp.value,
                placeholder = "",
                onValueChange = {
                    viewModel.onChangeTelp(it)
                }
            )
        }

        item {
            Spacer(modifier = Modifier.height(14.dp))
            Text(text = "Password", style = Type.textSmMedium())
            CustomTextField(
                text = viewModel.password.value,
                placeholder = "",
                isPassword = true,
                showPassword = viewModel.isVisible.value,
                trailingIcon = Icons.Default.Visibility,
                onValueChange = {
                    viewModel.onChangePassword(it)
                },
                onPasswordToggle = {
                    viewModel.onTogglePassword()
                }
            )
        }

        item {
            Spacer(modifier = Modifier.height(14.dp))
            Text(text = "Konfirmasi Sandi", style = Type.textSmMedium())
            CustomTextField(
                text = viewModel.rePassword.value,
                placeholder = "",
                isPassword = true,
                showPassword = viewModel.isReVisible.value,
                trailingIcon = Icons.Default.Visibility,
                onValueChange = {
                    viewModel.onChangeRePassword(it)
                },
                onPasswordToggle = {
                    viewModel.onToggleRePassword()
                }
            )
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
            CustomButton(
                onClick = {
                    viewModel.onSubmit(context)
                },
                text = "Daftar",
                type = ButtonType.LARGE
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}