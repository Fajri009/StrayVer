package com.fajri.strayver.ui.presentation.relawan.buatProyek.component

import android.content.Context
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.fajri.strayver.data.Resource
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.presentation.component.CustomTextField
import com.fajri.strayver.ui.presentation.component.PickImage
import com.fajri.strayver.ui.presentation.component.PickImageBuatProyek
import com.fajri.strayver.ui.presentation.relawan.buatProyek.BuatProyekViewModel
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Neutral700
import com.fajri.strayver.ui.theme.Neutral900
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.ButtonType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun BuatProyekForm(
    viewModel: BuatProyekViewModel,
    scope: CoroutineScope,
    context: Context,
    donasiType: String
) {

    val context= LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Neutral50)
            .padding(20.dp)
    ) {
        item {
            Text(
                text = "Donasi $donasiType",
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
                maxLine = 8
            )
            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            Text(
                text = "Jumlah Maksimal Dana $donasiType",
                color = Color.Black,
                style = Type.textSmMedium()
            )
            CustomTextField(
                text =
                if (viewModel.jumlahMaks.value.toString() == "null") {
                    ""
                } else {
                    viewModel.jumlahMaks.value.toString()
                },
                placeholder = "",
                onValueChange = {
                    if (it == "") {
                        viewModel.onChangeJumlahMaks(null)
                    } else {
                        viewModel.onChangeJumlahMaks(it.toLong())
                    }
                },
                isNumeric = true
            )
            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            Text(
                text = "Foto Proyek",
                color = Color.Black,
                style = Type.textSmMedium()
            )
            PickImageBuatProyek(viewModel = viewModel)
            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            CustomButton(
                onClick = {
                    if (viewModel.isValid(context)) {
                        scope.launch {
                            viewModel.buatProyek(context).collect {
                                when (it) {
                                    is Resource.Loading -> {
                                        viewModel.setLoading(true)
                                    }

                                    is Resource.Success -> {
                                        viewModel.setDialog(true)
                                    }

                                    is Resource.Error -> {
                                        viewModel.setLoading(false)
                                        Toast.makeText(context, it.message, Toast.LENGTH_SHORT)
                                            .show()
                                    }
                                }
                            }
                        }
                    }
                },
                text = "Kirim",
                type = ButtonType.LARGE
            )
        }
    }
}