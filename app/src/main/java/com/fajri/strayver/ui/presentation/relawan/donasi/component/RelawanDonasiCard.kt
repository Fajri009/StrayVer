package com.fajri.strayver.ui.presentation.relawan.donasi.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.component.CompanyTag
import com.fajri.strayver.ui.presentation.component.CustomProgressBar
import com.fajri.strayver.ui.theme.Neutral600
import com.fajri.strayver.ui.theme.Neutral800
import com.fajri.strayver.ui.theme.Secondary900
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RelawanDonasiCard(
    image: Int,
    companyName: String,
    companyIcon: Int,
    judul: String,
    progress: Float,
    terkumpul: String,
    onClick: () -> Unit
) {
    Card(
        onClick = {
            onClick()
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
                modifier = Modifier.clip(RoundedCornerShape(10.dp)),
                model = image,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Row {
                    CompanyTag(companyName = companyName, companyIcon = companyIcon)
                }
                Text(
                    text = judul,
                    style = Type.textXsSemiBold(),
                    color = Neutral800
                )
                Spacer(modifier = Modifier.height(5.dp))
                CustomProgressBar(progress = progress)
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Terkumpul :",
                    style = Type.text2xsRegular(),
                    color = Neutral600
                )
                Text(
                    text = terkumpul,
                    style = Type.textXsSemiBold(),
                    color = Secondary900
                )
            }
        }
    }
}