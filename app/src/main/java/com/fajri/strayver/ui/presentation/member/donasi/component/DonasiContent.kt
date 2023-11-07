package com.fajri.strayver.ui.presentation.member.donasi.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.R
import com.fajri.strayver.ui.theme.Primary100
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Type

@Composable
fun DonasiContent(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(30.dp))
            .background(Color.White)
            .padding(top = 20.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
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
                .padding(top = 16.dp)
        ) {
            Divider(Modifier.height(2.dp), color = Primary100)
        }

        LazyColumn(Modifier.fillMaxSize()) {
            items(3) {
                DonasiCard(
                    type = "Dana",
                    img = R.drawable.kucing_makan,
                    title = "Selamatkan ratusan kucing kelaparan di Kecamatan Tou",
                    companyName = "Anabul Foundation",
                    companyIcon = R.drawable.anabul_foundation,
                    progress = .45f,
                    value = 3258000,
                    navController
                )
            }
        }
    }
}