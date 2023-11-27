package com.fajri.strayver.ui.presentation.member.riwayat.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.component.CompanyTag
import com.fajri.strayver.ui.theme.Neutral700
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.Route

@Composable
fun RiwayatItem(type: String, navController: NavController) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 8.dp)
            .clickable {
                navController.navigate(Route.DETAIL_RIWAYAT)
            },
        horizontalArrangement = Arrangement.spacedBy(27.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            AsyncImage(
                model =
                when (type) {
                    "dana" -> R.drawable.ic_riwayat_dana
                    "barang" -> R.drawable.ic_riwayat_barang
                    else -> ""
                },
                contentDescription = type,
                modifier = Modifier.sizeIn(maxWidth = 48.dp, minWidth = 48.dp)
            )

            Column(
                horizontalAlignment = Alignment.Start
            ) {
                CompanyTag(
                    companyName = "Anabul Foundation",
                    companyIcon = "R.drawable.anabul_foundation"
                )
                Text(
                    text = "Selamatkan ratusan kucing kelaparan",
                    style = Type.textSmBold(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Neutral700
                )
            }
        }
        Text(
            text =
            when (type) {
                "dana" -> "Rp 50.000"
                "barang" -> "3 pcs"
                else -> ""
            },
            style = Type.textMdBold(),
            color = Primary900
        )
    }
}