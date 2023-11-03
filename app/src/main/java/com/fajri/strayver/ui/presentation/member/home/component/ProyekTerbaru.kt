package com.fajri.strayver.ui.presentation.member.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Type

@Composable
fun ProyekTerbaru() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 8.dp, bottom = 8.dp, start = 20.dp)
    ) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Proyek Terbaru", style = Type.textMdSemiBold())
            Text(text = "Lihat Semua >", style = Type.textMdRegular(), color = Primary900,
                modifier = Modifier.clickable {

                }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(4) {
                ProyekCard()
            }
        }
    }
}