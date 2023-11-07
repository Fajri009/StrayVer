package com.fajri.strayver.ui.presentation.member.kirim_donasi.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.ui.presentation.component.CustomTextField
import com.fajri.strayver.ui.presentation.component.PickImage
import com.fajri.strayver.ui.theme.Type

@Composable
fun FormBarang(navController: NavController, modifier: Modifier= Modifier) {
    LazyColumn(modifier = modifier) {
        item {
            Text(text = "Donasikan Barang", style = Type.textXlSemiBold())
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = "Ceritakan lebih lanjut tentang barangmu!", style = Type.textSmRegular())
        }

        item {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Nama Produk", style = Type.textMdMedium())
            CustomTextField(text = "", placeholder = "")
        }

        item {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Nama Pengirim", style = Type.textMdMedium())
            CustomTextField(text = "", placeholder = "")
        }

        item {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Deskripsi", style = Type.textMdMedium())
            CustomTextField(text = "", placeholder = "", minLine = 4, maxLine = 5)
        }

        item {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Nomer Resi", style = Type.textMdMedium())
            CustomTextField(text = "", placeholder = "")
        }

        item {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Jumlah", style = Type.textMdMedium())
            CustomTextField(text = "", placeholder = "")
        }

        item {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Gambar", style = Type.textMdMedium())
            PickImage()
        }
    }
}