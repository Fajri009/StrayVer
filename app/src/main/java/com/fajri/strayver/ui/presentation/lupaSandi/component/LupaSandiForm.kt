package com.fajri.strayver.ui.presentation.lupaSandi.component

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.presentation.component.CustomTextField
import com.fajri.strayver.ui.presentation.lupaSandi.LupaSandiViewModel
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.ButtonType

@Composable
fun LupaSandiForm(viewModel: LupaSandiViewModel, context: Context) {

    Column(
        Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Neutral50)
            .padding(20.dp)
    ) {
        Text(text = "Masukkan email yang digunakan pada akunmu", style = Type.textXsRegular())
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Email", style = Type.textSmMedium())
        CustomTextField(
            text = viewModel.email.value,
            placeholder = "",
            onValueChange = {
                viewModel.onChangeEmail(it)
            }
        )
        Spacer(modifier = Modifier.height(12.dp))
        CustomButton(
            onClick = {
                viewModel.onSubmit(context)
            },
            text = "Kirim",
            type = ButtonType.LARGE
        )
    }
}