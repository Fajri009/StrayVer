package com.fajri.strayver.ui.presentation.member.detail_donasi.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.fajri.strayver.model.Donasi
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.presentation.member.detail_donasi.DetaiDonasiViewModel
import com.fajri.strayver.ui.theme.Neutral800
import com.fajri.strayver.ui.theme.Primary50
import com.fajri.strayver.ui.theme.Primary800
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.ButtonType
import com.fajri.strayver.util.Route

@Composable
fun KetentuanDialog(navController: NavController, donasi: Donasi, viewModel: DetaiDonasiViewModel) {
    Dialog(onDismissRequest = {
        viewModel.setDialog(false)
    }) {
        Card(
            colors = CardDefaults.cardColors(containerColor = Primary50),
            shape = RoundedCornerShape(30.dp),
        ) {
            Column(
                Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .padding(top = 20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Donasi Barang", style = Type.textLgSemiBold(), color = Primary800)
                Spacer(modifier = Modifier.height(12.dp))
                Column(
                    Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .background(Shades50)
                        .padding(20.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "Cara dan Ketentuan Donasi Barang",
                        style = Type.textMdSemiBold(),
                        color = Primary900,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "1.\tCara dan Ketentuan Donasi Barang",
                        style = Type.textSmRegular(),
                        color = Neutral800
                    )
                    Text(
                        text = "2.\tKirim ke ekspedisi pilihanmu",
                        style = Type.textSmRegular(),
                        color = Neutral800,
                    )
                    Text(
                        text = "3.\tIsi formulir yang yang kami sediakan sesuai dengan spesifikasi barang dan pengiriman, termasuk nomor resi maupun nama ekspedisi",
                        style = Type.textSmRegular(),
                        color = Neutral800
                    )
                    Text(
                        text = "4.\tKlik tombol Kirim",
                        style = Type.textSmRegular(),
                        color = Neutral800
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        CustomButton(
                            onClick = {
                                navController.navigate(
                                    Route.KIRIM_DONASI + "?namaDonasi=${donasi.title}" +
                                            "?donasiId=${donasi.donasiId}" +
                                            "?type=${donasi.category}" + "?relawan=${donasi
                                                .relawanNama}" + "?idRelawan=${donasi.userId}"
                                )
                            },
                            text = "Baik",
                            type = ButtonType.MEDIUM
                        )
                    }
                }
            }
        }
    }
}