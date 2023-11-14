package com.fajri.strayver.ui.presentation.member.riwayat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.fajri.strayver.ui.theme.Primary100
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type

@Composable
fun RiwayatContent() {
    Column(
        Modifier
            .padding(top = 120.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Shades50)

    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "Semua",
                style = Type.textSmSemiBold(),
                color = Primary900,
                modifier = Modifier.clickable {

                })
            Text(
                text = "Dana",
                style = Type.textSmSemiBold(),
                color = Primary900,
                modifier = Modifier.clickable {

                })
            Text(
                text = "Barang",
                style = Type.textSmSemiBold(),
                color = Primary900,
                modifier = Modifier.clickable {

                }
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Divider(Modifier.height(2.dp), color = Primary100)
            RiwayatItem(type = "dana")
        }
    }
}
