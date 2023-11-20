package com.fajri.strayver.ui.presentation.relawan.riwayat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Neutral800
import com.fajri.strayver.ui.theme.Primary100
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type

@Composable
fun RelawanRiwayatContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Neutral50, RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Shades50, RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .padding(top = 15.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                modifier = Modifier
                    .clickable {  },
                text = "Semua",
                color = Neutral800,
                style = Type.textSmMedium(),
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .clickable {  },
                text = "Dana",
                color = Neutral800,
                style = Type.textSmMedium(),
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .clickable {  },
                text = "Barang",
                color = Neutral800,
                style = Type.textSmMedium(),
                textAlign = TextAlign.Center
            )
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth(),
            color = Primary100
        )
        LazyColumn() {
            item {
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier
                            .background(
                                Primary100,
                                RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp)
                            )
                            .padding(top = 2.dp, bottom = 2.dp, start = 20.dp, end = 20.dp),
                        text = "21 September 2023",
                        color = Primary900,
                        style = Type.text2xsSemiBold()
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    RelawanRiwayatKategoriData1()
                }
            }

            item {
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier
                            .background(
                                Primary100,
                                RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp)
                            )
                            .padding(top = 2.dp, bottom = 2.dp, start = 20.dp, end = 20.dp),
                        text = "21 September 2023",
                        color = Primary900,
                        style = Type.text2xsSemiBold()
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    RelawanRiwayatKategoriData1()
                }
            }

            item {
                Spacer(modifier = Modifier.height(55.dp))
            }
        }
    }
}