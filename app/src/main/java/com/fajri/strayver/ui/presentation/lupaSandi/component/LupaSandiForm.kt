package com.fajri.strayver.ui.presentation.lupaSandi.component

import android.content.Context
import android.widget.Toast
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
import com.fajri.strayver.data.Resource
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.presentation.component.CustomTextField
import com.fajri.strayver.ui.presentation.lupaSandi.LupaSandiViewModel
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.ButtonType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun LupaSandiForm(viewModel: LupaSandiViewModel, context: Context, scope: CoroutineScope) {

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
                if (!viewModel.isValid()) {
                    scope.launch {
                        viewModel.onSubmit().collect {
                            when(it) {
                                is Resource.Loading -> {
                                    viewModel.setLoading(true)
                                }
                                is Resource.Success -> {
                                    viewModel.setDialog(true)
                                }
                                is Resource.Error -> {
                                    Toast.makeText(context, it.message.toString(), Toast
                                        .LENGTH_SHORT).show()
                                }
                                else -> Unit
                            }
                        }
                    }
                } else {
                    Toast.makeText(context, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show()
                }
            },
            text = "Kirim",
            type = ButtonType.LARGE
        )
    }
}