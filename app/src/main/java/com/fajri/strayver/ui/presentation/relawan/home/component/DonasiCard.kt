package com.fajri.strayver.ui.presentation.relawan.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fajri.strayver.ui.theme.Neutral300
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Neutral900
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Type

@Composable
fun DonasiCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(Neutral50),
        elevation = CardDefaults.cardElevation(12.dp),

    ) {
        Column(
            Modifier
                .background(Primary900)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = "Donasi Terkumpul",
                color = Neutral50,
                style = Type.textXsSemiBold(),
            )
            Row(
                modifier = Modifier
                    .background(Neutral50)
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Total Dana",
                        color = Neutral900,
                        style = Type.text2xsRegular()
                    )
                    Text(
                        text = "Rp 3.258.500",
                        color = Neutral900,
                        style = Type.textSmSemiBold()
                    )
                }
                Divider(
                    color = Neutral300,
                    modifier = Modifier
                        .width(3.dp)
                        .height(42.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                Spacer(modifier = Modifier.width(20.dp))
                Column(
                    modifier = Modifier.padding(end = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Total Barang",
                        color = Neutral900,
                        style = Type.text2xsRegular()
                    )
                    Text(
                        text = "3",
                        color = Neutral900,
                        style = Type.textSmSemiBold()
                    )
                }
            }
        }
    }
}