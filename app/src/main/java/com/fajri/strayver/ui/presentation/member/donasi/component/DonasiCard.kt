package com.fajri.strayver.ui.presentation.member.donasi.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
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
import com.fajri.strayver.ui.presentation.component.CompanyTag
import com.fajri.strayver.ui.presentation.component.CustomProgressBar
import com.fajri.strayver.ui.theme.Neutral600
import com.fajri.strayver.ui.theme.Secondary900
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.Route

@Composable
fun DonasiCard(
    type: String,
    img: Int,
    title: String,
    companyName: String,
    companyIcon: Int,
    progress: Float,
    value: Any,
    navController: NavController
) {
    Card(
        Modifier
            .padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 0.dp)
            .clickable {
                navController.navigate(Route.DETAIL_DONASI)
            },
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            Modifier.padding(horizontal = 16.dp, vertical = 4.dp), verticalAlignment = Alignment
                .CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            AsyncImage(
                model = img,
                contentDescription = "",
                modifier = Modifier
                    .sizeIn(maxWidth = 90.dp, maxHeight = 90.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                CompanyTag(companyName = companyName, companyIcon = companyIcon)
                Text(
                    text = title,
                    style = Type.textSmSemiBold(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                CustomProgressBar(progress = progress)

                Column {
                    Text(text = "Terkumpul :", style = Type.text2xsRegular(), color = Neutral600)
                    if (type.equals("Dana")) {
                        Text(
                            text = "Rp $value",
                            style = Type.textXsSemiBold(),
                            color = Secondary900
                        )
                    } else {
                        Text(
                            text = "$value barang",
                            style = Type.textXsSemiBold(),
                            color = Secondary900
                        )
                    }
                }
            }
        }
    }
}