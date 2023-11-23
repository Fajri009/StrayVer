package com.fajri.strayver.ui.presentation.member.home.component

import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.model.Artikel
import com.fajri.strayver.ui.theme.Neutral500
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.Route

@Composable
fun ArtikelItemCard(artikel: Artikel, navController: NavController) {
    Card(
        Modifier
            .padding(vertical = 8.dp, horizontal = 20.dp)
            .clickable {
                navController.navigate(Route.ARTIKEL_DETAIL)
            },
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
                        model = artikel.posterAvatar,
                        contentDescription = "",
                        Modifier
                            .clip(CircleShape)
                            .sizeIn(maxWidth = 36.dp, maxHeight = 36.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = artikel.posterName, style = Type.textXsRegular())
                }
                Text(
                    text = artikel.title,
                    style = Type.textSmSemiBold(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(text = artikel.waktu, style = Type.text2xsRegular(), color = Neutral500)
            }

            AsyncImage(
                model = artikel.artikelPhoto,
                contentDescription = "",
                modifier = Modifier
                    .sizeIn(maxWidth = 100.dp, maxHeight = 100.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}