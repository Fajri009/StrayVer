package com.fajri.strayver.ui.presentation.relawan.buatProyek.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.presentation.component.CustomTextField
import com.fajri.strayver.ui.presentation.relawan.buatProyek.BuatProyekViewModel
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Neutral700
import com.fajri.strayver.ui.theme.Neutral900
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.ButtonType

@Composable
fun BuatProyekContent(viewModel: BuatProyekViewModel, ) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Neutral50)
            .padding(20.dp)
    ) {
        item {
            Text(
                text = "Donasi Dana",
                color = Neutral900,
                style = Type.textLgSemiBold()
            )
            Text(
                text = "Deskripsikan proyek donasimu",
                color = Neutral700,
                style = Type.textXsRegular()
            )
            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            Text(
                text = "Nama Proyek",
                color = Color.Black,
                style = Type.textSmMedium()
            )
            CustomTextField(
                text = viewModel.namaProyek.value,
                placeholder = "",
                onValueChange = {
                    viewModel.onChangeNamaProyek(it)
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            Text(
                text = "Deskripsi",
                color = Color.Black,
                style = Type.textSmMedium()
            )
            CustomTextField(
                text = viewModel.deskripsi.value,
                placeholder = "",
                onValueChange = {
                    viewModel.onChangeDeskripsi(it)
                },
                minLine = 8,
                maxLine = 8)
            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            Text(
                text = "Jumlah Maksimal Dana Donasi",
                color = Color.Black,
                style = Type.textSmMedium()
            )
            CustomTextField(
                text = viewModel.jumlahMaks.value,
                placeholder = "",
                onValueChange = {
                    viewModel.onChangeJumlahMaks(it)
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            Text(
                text = "Foto Proyek",
                color = Color.Black,
                style = Type.textSmMedium()
            )
            CustomTextField(
                text = "",
                placeholder = ""
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            CustomButton(onClick = { /*TODO*/ }, text = "Kirim", type = ButtonType.LARGE)
        }
    }
}