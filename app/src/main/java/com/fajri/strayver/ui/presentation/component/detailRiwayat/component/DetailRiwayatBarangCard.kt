package com.fajri.strayver.ui.presentation.relawan.detailRiwayat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import coil.compose.AsyncImage
import com.fajri.strayver.model.Transaksi
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.presentation.component.detailRiwayat.DetailRiwayatViewModel
import com.fajri.strayver.ui.theme.Neutral800
import com.fajri.strayver.ui.theme.Primary200
import com.fajri.strayver.ui.theme.Primary50
import com.fajri.strayver.ui.theme.Primary800
import com.fajri.strayver.ui.theme.Secondary900
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Success900
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.ui.theme.Warning900
import com.fajri.strayver.util.ButtonType
import com.fajri.strayver.util.DonaturProgres
import com.fajri.strayver.util.formatLongWithDots
import com.fajri.strayver.util.toDateString

@Composable
fun DetailRiwayatBarangCard(transaksi: Transaksi, role: String, viewModel: DetailRiwayatViewModel) {
    Column {
        Card(
            elevation = CardDefaults.cardElevation(5.dp)
        ) {
            Column(
                modifier = Modifier.background(Primary50)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    text = "Donasi Barang",
                    color = Primary800,
                    style = Type.textLgSemiBold(),
                    textAlign = TextAlign.Center
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Shades50, RoundedCornerShape(10.dp))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Text(
                            text = "Kode Donasi: ${transaksi.donasiId}",
                            color = Neutral800,
                            style = Type.text2xsBold()
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "Proyek Donasi",
                            color = Color.Black,
                            style = Type.textSmSemiBold()
                        )
                        Text(
                            text = transaksi.title,
                            color = Color.Black,
                            style = Type.textXsRegular()
                        )
                        Divider(
                            modifier = Modifier.fillMaxWidth(),
                            color = Primary200
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {
                                Text(
                                    text = if (role == "member")
                                        "Nama Relawan"
                                    else
                                        "Nama Donatur",
                                    color = Color.Black,
                                    style = Type.textSmSemiBold()
                                )
                                Text(
                                    text =
                                        if (role == "member") {
                                            transaksi.namaRelawan
                                        } else {
                                            transaksi.namaMember
                                        },
                                    color = Color.Black,
                                    style = Type.textXsRegular()
                                )
                            }
                            Column(
                                modifier = Modifier.weight(.4f)
                            ) {
                                Text(
                                    text = "Jumlah Barang",
                                    color = Color.Black,
                                    style = Type.textSmSemiBold()
                                )
                                Text(
                                    text = formatLongWithDots(transaksi.income),
                                    color = Color.Black,
                                    style = Type.textXsRegular()
                                )
                            }
                        }
                        Divider(
                            modifier = Modifier.fillMaxWidth(),
                            color = Primary200
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {
                                Text(
                                    text = "Tanggal Donasi",
                                    color = Color.Black,
                                    style = Type.textSmSemiBold()
                                )
                                Text(
                                    text = (transaksi.tanggal).toDateString(),
                                    color = Color.Black,
                                    style = Type.textXsRegular()
                                )
                            }
                            Column(
                                modifier = Modifier.weight(.4f)
                            ) {
                                Text(
                                    text = "Status",
                                    color = Color.Black,
                                    style = Type.textSmSemiBold()
                                )
                                Text(
                                    text = transaksi.status,
                                    color =
                                    when (transaksi.status) {
                                        DonaturProgres.PROSES -> Warning900
                                        DonaturProgres.SELESAI -> Success900
                                        else -> Color.Black
                                    },
                                    style = Type.textXsSemiBold()
                                )
                            }
                        }
                        Divider(
                            modifier = Modifier.fillMaxWidth(),
                            color = Primary200
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {
                                Text(
                                    text = "Ekspedisi",
                                    color = Color.Black,
                                    style = Type.textSmSemiBold()
                                )
                                Text(
                                    text = transaksi.ekspedisi,
                                    color = Color.Black,
                                    style = Type.textXsRegular()
                                )
                            }
                            Column(
                                modifier = Modifier.weight(.4f)
                            ) {
                                Text(
                                    text = "Nomor Resi",
                                    color = Color.Black,
                                    style = Type.textSmSemiBold()
                                )
                                Text(
                                    text = transaksi.resi,
                                    color = Color.Black,
                                    style = Type.textXsRegular()
                                )
                            }
                        }
                        Divider(
                            modifier = Modifier.fillMaxWidth(),
                            color = Primary200
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Deskripsi",
                            color = Color.Black,
                            style = Type.textSmSemiBold()
                        )
                        Text(
                            text = transaksi.deskripsi,
                            color = Color.Black,
                            style = Type.textXsRegular()
                        )
                        Divider(
                            modifier = Modifier.fillMaxWidth(),
                            color = Primary200
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Gambar Barang",
                            color = Color.Black,
                            style = Type.textSmSemiBold()
                        )
                        AsyncImage(
                            model = transaksi.gambar,
                            contentDescription = "",
                            modifier = Modifier.size(100.dp)
                        )
                    }
                }
            }
        }

        if (role == "relawan") {
            when (transaksi.status) {
                DonaturProgres.PROSES -> {
                    Spacer(modifier = Modifier.height(25.dp))
                    CustomButton(
                        onClick = {

                        },
                        text = "Diterima",
                        type = ButtonType.LARGE
                    )
                }
            }
        }
    }
}