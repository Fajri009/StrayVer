package com.fajri.strayver.ui.presentation.member.donasi.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.model.Donasi
import com.fajri.strayver.ui.presentation.component.CompanyTag
import com.fajri.strayver.ui.presentation.component.CustomProgressBar
import com.fajri.strayver.ui.presentation.member.donasi.MemberDonasiViewModel
import com.fajri.strayver.ui.theme.Neutral600
import com.fajri.strayver.ui.theme.Secondary900
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.Route
import com.fajri.strayver.util.TipeDonasi
import com.fajri.strayver.util.formatLongWithDots

@Composable
fun DonasiCard(
    dataDonasi: Donasi,
    navController: NavController,
    viewModel: MemberDonasiViewModel
) {

    val progress = dataDonasi.donasiGain.toFloat() / dataDonasi.donasiGoal!!.toFloat()
    val relawaData by viewModel.relawanData

    LaunchedEffect(key1 = true, block = {
        viewModel.getRelawanData(dataDonasi.userId)
    })

    Card(
        Modifier
            .padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 0.dp)
            .clickable {
                navController.navigate(Route.DETAIL_DONASI + "?donasiId=${dataDonasi.donasiId}")
            },
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            Modifier.padding(horizontal = 16.dp, vertical = 4.dp), verticalAlignment = Alignment
                .CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            AsyncImage(
                model = dataDonasi.gambar,
                contentDescription = "",
                modifier = Modifier
                    .sizeIn(maxWidth = 90.dp, maxHeight = 90.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                CompanyTag(
                    companyName = dataDonasi.relawanNama,
                    companyIcon = relawaData.avatar
                )
                Text(
                    text = dataDonasi.title,
                    style = Type.textSmSemiBold(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                CustomProgressBar(progress = progress)

                Column {
                    Text(text = "Terkumpul :", style = Type.text2xsRegular(), color = Neutral600)
                    if (dataDonasi.category.equals(TipeDonasi.DANA)) {
                        Text(
                            text = "Rp ${formatLongWithDots(dataDonasi.donasiGain)}",
                            style = Type.textXsSemiBold(),
                            color = Secondary900
                        )
                    } else {
                        Text(
                            text = "${dataDonasi.donasiGain} barang",
                            style = Type.textXsSemiBold(),
                            color = Secondary900
                        )
                    }
                }
            }
        }
    }
}