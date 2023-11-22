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
    modifier: Modifier = Modifier
) {

    val scope= rememberCoroutineScope()

    LazyColumn(modifier = modifier) {
        item {
            Text(text = "Donasikan Barang", style = Type.textXlSemiBold())
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = "Ceritakan lebih lanjut tentang barangmu!", style = Type.textSmRegular())
        }

        item {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Nama Produk", style = Type.textSmMedium())
            CustomTextField(text = "", placeholder = "")
        }

        item {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Nama Pengirim", style = Type.textSmMedium())
            CustomTextField(text = "", placeholder = "")
        }

        item {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Deskripsi", style = Type.textSmMedium())
            CustomTextField(text = "", placeholder = "", minLine = 4, maxLine = 5)
        }

        item {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Nomer Resi", style = Type.textSmMedium())
            CustomTextField(text = "", placeholder = "")
        }

        item {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Jumlah", style = Type.textSmMedium())
            CustomTextField(text = "", placeholder = "")
        }

        item {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Gambar", style = Type.textSmMedium())
            PickImage(viewModel)
        }

        item {
            Spacer(modifier = Modifier.height(8.dp))
            CustomButton(onClick = {
                scope.launch {
                    viewModel.onUploadFile(context).collect {
                        when(it) {
                            is Resource.Loading -> {
                                viewModel.setLoading(true)
                            }
                            is Resource.Success -> {
                                viewModel.setLoading(false)
//                                Toast.makeText(context, it.data, Toast
//                                    .LENGTH_SHORT).show()
                                navController.navigate(Route.MEMBER_RIWAYAT)
                            }
                            is Resource.Error -> {
                                viewModel.setLoading(false)
                                Toast.makeText(context, it.message, Toast
                                    .LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            }, text = "Kirim", type = ButtonType.LARGE)
        }
    }
}