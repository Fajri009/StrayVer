package com.fajri.strayver.ui.presentation.member.kirim_donasi.component

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.data.Resource
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.presentation.component.CustomTextField
import com.fajri.strayver.ui.presentation.component.PickImage
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.ButtonType
import com.fajri.strayver.util.Route
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun FormBarang(
    navController: NavController, context: Context, viewModel: KirimDonasiViewModel,
    modifier: Modifier = Modifier, namaDonasi: String, donasiId: String, donasiType: String,
    relawan: String,
) {

    val scope = rememberCoroutineScope()

    LazyColumn(modifier = modifier) {
        item {
            Text(text = "Donasikan Barang", style = Type.textXlSemiBold())
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = "Ceritakan lebih lanjut tentang barangmu!", style = Type.textSmRegular())
        }

        item {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Nama Pengirim", style = Type.textSmMedium())
            CustomTextField(
                text = viewModel.pengirim.value,
                placeholder = "",
                onValueChange = {
                    viewModel.onPengirimChange(it)
                }
            )
        }

        item {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Deskripsi", style = Type.textSmMedium())
            CustomTextField(
                text = viewModel.deskripsi.value,
                placeholder = "",
                minLine = 4,
                maxLine = 5,
                onValueChange = {
                    viewModel.onDeskripsiChange(it)
                }
            )
        }

        item {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Ekspedisi", style = Type.textSmMedium())
            CustomTextField(
                text = viewModel.ekspedisi.value,
                placeholder = "",
                minLine = 4,
                maxLine = 5,
                onValueChange = {
                    viewModel.onEkspedisiChange(it)
                }
            )
        }

        item {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Nomer Resi", style = Type.textSmMedium())
            CustomTextField(
                text = viewModel.resi.value,
                placeholder = "",
                onValueChange = {
                    viewModel.onResiChange(it)
                }
            )
        }

        item {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Jumlah", style = Type.textSmMedium())
            CustomTextField(
                text = viewModel.jumlah.value.toString(),
                placeholder = "",
                isNumeric = true,
                onValueChange = {
                    viewModel.onJumlahChange(it)
                }
            )
        }

        item {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Gambar", style = Type.textSmMedium())
            PickImage(viewModel)
        }

        item {
            Spacer(modifier = Modifier.height(8.dp))
            CustomButton(
                text = "Kirim",
                type = ButtonType.LARGE,
                onClick = {
                    viewModel.donasiBarangSubmit(context, namaDonasi= namaDonasi, donasiId=
                    donasiId, donasiType= donasiType, relawan= relawan)
                }
            )
        }
    }
}