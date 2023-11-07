package com.fajri.strayver.ui.presentation.member.detail_donasi.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.component.CustomProgressBar
import com.fajri.strayver.ui.theme.Neutral600
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Secondary900
import com.fajri.strayver.ui.theme.Type

@Composable
fun ContentHead() {
    Column {
        Text(
            text = "Selamatkan ratusan kucing kelaparan di kecamatan Tou",
            style = Type.textLgBold(),
            color = Primary900,
        )
        Spacer(modifier = Modifier.height(12.dp))

        Column(Modifier.fillMaxWidth()) {
            CustomProgressBar(progress = .45f)
            Spacer(modifier = Modifier.height(2.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Terkumpul :", style = Type.textXsRegular(), color = Neutral600)
                Text(
                    text = "dari Rp 10.000.000",
                    style = Type.textXsRegular(),
                    color = Neutral600
                )
            }
            Text(text = "Rp 3.258.500", style = Type.textSmSemiBold(), color= Secondary900)

            Spacer(modifier = Modifier.height(12.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(11.dp)) {
                AsyncImage(
                    model = R.drawable.anabul_foundation,
                    contentDescription = "",
                    Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Column(verticalArrangement = Arrangement.Center) {
                    Text(text = "Anabul Foundation", style = Type.textSmSemiBold())
                    Text(text = "2 jam yang lalu", style = Type.textXsRegular(), color = Neutral600)
                }
            }
        }
    }
}