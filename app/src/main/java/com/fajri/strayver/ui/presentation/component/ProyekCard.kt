package com.fajri.strayver.ui.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
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
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.model.Donasi
import com.fajri.strayver.ui.presentation.component.CustomProgressBar
import com.fajri.strayver.ui.theme.Neutral600
import com.fajri.strayver.ui.theme.Secondary900
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.Route
import com.fajri.strayver.util.formatLongWithDots

@Composable
fun ProyekCard(navController: NavController, donasi: Donasi) {

    val formattedGoal= formatLongWithDots(donasi.donasiGoal!!)
    val formattedGain= formatLongWithDots(donasi.donasiGain)
    val progress= donasi.donasiGain.toFloat() / donasi.donasiGoal.toFloat()
    Card(
        shape = RoundedCornerShape(25.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = Modifier
            .width(200.dp)
            .clickable {
                navController.navigate(Route.DETAIL_DONASI + "?donasiId=${donasi.donasiId}")
            }
    ) {

        AsyncImage(
            model = donasi.gambar,
            contentDescription = "",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.height(120.dp)
        )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                AsyncImage(
                    model = R.drawable.anabul_foundation,
                    contentDescription = "",
                    modifier = Modifier
                        .size(width= 16.dp, height = 16.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
                Text(text = donasi.relawanNama, style = Type.text2xsRegular(), color = Neutral600)
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = donasi.title,
                style = Type.textXsSemiBold(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(6.dp))
            CustomProgressBar(progress = progress)

            Spacer(modifier = Modifier.height(6.dp))
            Text(text = "Terkumpul:", style = Type.text2xsRegular(), color = Neutral600)
            if (donasi.category == "Barang") {
                Text(text = "$formattedGain barang", style = Type.textXsSemiBold(), color =
                Secondary900)
            } else {
                Text(text = "Rp${formattedGain}", style = Type.textXsSemiBold(), color = Secondary900)
            }
        }
    }
}