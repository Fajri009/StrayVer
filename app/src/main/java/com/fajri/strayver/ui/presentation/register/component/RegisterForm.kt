package com.fajri.strayver.ui.presentation.register.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.ui.presentation.component.CustomTextField
import com.fajri.strayver.ui.presentation.register.RegisterViewModel
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Type

@Composable
fun RegisterForm(viewModel: RegisterViewModel, navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(text = "Selamat Datang", style = Type.textLgSemiBold(), color = Primary900)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Halo, bergabunglah dengan kami untuk memulai!", style = Type.textXsRegular())
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Nama Lengkap", style = Type.textSmMedium())
        CustomTextField(
            text = viewModel.nama.value,
            placeholder = "",
            onValueChange = {
                viewModel.onChangeNama(it)
            }
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(text = "Nama Lengkap", style = Type.textSmMedium())
    }
}