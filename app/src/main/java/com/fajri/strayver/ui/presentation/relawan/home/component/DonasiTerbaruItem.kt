package com.fajri.strayver.ui.presentation.relawan.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.model.Donasi
import com.fajri.strayver.ui.presentation.component.CustomProgressBar
import com.fajri.strayver.ui.theme.Neutral600
import com.fajri.strayver.ui.theme.Neutral800
import com.fajri.strayver.ui.theme.Secondary900
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.Route
import com.fajri.strayver.util.TipeDonasi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DonasiTerbaruItem(
    navController: NavController,
    donasiData: Donasi
) {
    Row(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Card(
            onClick = {
                navController.navigate(Route.TAMBAH_DONASI + "?type=${donasiData.category}")
            },
            elevation = CardDefaults.cardElevation(2.dp)
        ) {
            Row(
                modifier = Modifier
                    .background(Shades50)
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage (
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .size(100.dp),
                    model = donasiData.gambar,
                    contentDescription = "gambar proyek",
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Text(
                        text = donasiData.title,
                        style = Type.textXsSemiBold(),
                        color = Neutral800
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    CustomProgressBar(progress = donasiData.donasiGain.toFloat() / donasiData.donasiGoal!!.toFloat())
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Terkumpul :",
                        style = Type.text2xsRegular(),
                        color = Neutral600
                    )
                    Text(
                        text =
                        when (donasiData.category) {
                            TipeDonasi.BARANG -> "${donasiData.donasiGain.toInt()} barang"
                            TipeDonasi.DANA -> "Rp ${donasiData.donasiGain}"
                            else -> {""}
                        },
                        style = Type.textXsSemiBold(),
                        color = Secondary900
                    )
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}