package com.fajri.strayver.ui.presentation.member.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.theme.Neutral500
import com.fajri.strayver.ui.theme.Type

@Composable
fun ArtikelItemCard() {
    Card(
        Modifier
            .padding(vertical = 8.dp, horizontal = 20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(Modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    AsyncImage(
                        model = R.drawable.avatar,
                        contentDescription = "",
                        Modifier.clip(CircleShape).sizeIn(maxWidth = 40.dp)
                    )
                    Text(text = "Sasha Brauss", style = Type.textXsRegular())
                }
                Text(
                    text = "Rescue Puluhan Kucing yang ditinggal pemiliknya",
                    style = Type.textSmSemiBold(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(text = "2 jam yang lalu", style = Type.text2xsRegular(), color = Neutral500)
            }

            AsyncImage(
                model = R.drawable.kucing_kumpul,
                contentDescription = "",
                modifier = Modifier
                    .sizeIn(maxWidth = 90.dp, maxHeight = 90.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}