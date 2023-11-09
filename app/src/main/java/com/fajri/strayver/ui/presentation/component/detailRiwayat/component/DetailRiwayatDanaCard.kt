package com.fajri.strayver.ui.presentation.component.detailRiwayat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fajri.strayver.ui.theme.Neutral700
import com.fajri.strayver.ui.theme.Neutral800
import com.fajri.strayver.ui.theme.Primary200
import com.fajri.strayver.ui.theme.Secondary300
import com.fajri.strayver.ui.theme.Secondary50
import com.fajri.strayver.ui.theme.Secondary900
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type

@Composable
fun DetailRiwayatDanaCard(
    kode: String,
    judul: String,
    nama: String,
    tanggal: String,
    metode: String,
    total: String
) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Secondary50)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                text = "DonasiDana",
                color = Secondary900,
                style = Type.textLgSemiBold(),
                textAlign = TextAlign.Center
            )
            Box {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Shades50, RoundedCornerShape(10.dp))
                        .padding(20.dp)
                ) {
                    Text(
                        text = "Kode Donasi: $kode",
                        color = Neutral800,
                        style = Type.text2xsBold()
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    Column {
                        Text(
                            text = "Proyek Donasi",
                            color = Color.Black,
                            style = Type.textSmSemiBold()
                        )
                        Text(
                            text = judul,
                            color = Color.Black,
                            style = Type.textXsRegular()
                        )
                    }
                    Divider(
                        modifier = Modifier.fillMaxWidth(),
                        color = Secondary300
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.weight(.6f)
                        ) {
                            Text(
                                text = "Nama Relawan",
                                color = Color.Black,
                                style = Type.textSmSemiBold()
                            )
                            Text(
                                text = nama,
                                color = Color.Black,
                                style = Type.textXsRegular()
                            )
                        }
                        Column(
                            modifier = Modifier.weight(.5f)
                        ) {
                            Text(
                                text = "Tanggal",
                                color = Color.Black,
                                style = Type.textSmSemiBold()
                            )
                            Text(
                                text = tanggal,
                                color = Neutral700,
                                style = Type.textXsRegular()
                            )
                        }
                    }
                    Divider(
                        modifier = Modifier.fillMaxWidth(),
                        color = Secondary300
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Metode Pembayaran",
                        color = Color.Black,
                        style = Type.textSmSemiBold()
                    )
                    Text(
                        text = metode,
                        color = Neutral700,
                        style = Type.textXsRegular()
                    )
                    Divider(
                        modifier = Modifier.fillMaxWidth(),
                        color = Secondary300
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Total Danasi",
                        color = Color.Black,
                        style = Type.textSmSemiBold()
                    )
                    Text(
                        text = "Rp $total",
                        color = Secondary900,
                        style = Type.textMdSemiBold()
                    )
                }
            }
        }
    }
}