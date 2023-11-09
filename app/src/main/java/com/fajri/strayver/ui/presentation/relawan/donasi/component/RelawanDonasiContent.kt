package com.fajri.strayver.ui.presentation.relawan.donasi.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.R
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Neutral800
import com.fajri.strayver.ui.theme.Primary100
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.Route

@Composable
fun RelawanDonasiContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Neutral50, RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
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
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth(),
            color = Primary100
        )
        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp)
        ) {
            RelawanDonasiCard(
                image = R.drawable.terbaru,
                companyName = "Anabul Foundation",
                companyIcon = R.drawable.anabul_foundation,
                judul = "Dibutuhkan kandang hewan (kucing atau anjing)",
                progress = 0.3f,
                terkumpul = "10 barang",
                onClick = {navController.navigate(Route.TAMBAH_DONASI)})
        }
    }
}