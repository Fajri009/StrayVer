package com.fajri.strayver.ui.presentation.relawan.profil.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fajri.strayver.ui.theme.Primary800
import com.fajri.strayver.ui.theme.Type

@Composable
fun RelawanInfoItem(
    title: String,
    value: String,
    isOverflow: Boolean = false,
    @DrawableRes
    icon: Int
) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = icon, contentDescription = title, Modifier.sizeIn(
                maxWidth = 36.dp,
                maxHeight = 36.dp
            )
        )
        Column(Modifier.weight(1f)) {
            Text(text = title, style = Type.textLgMedium(), color = Primary800)
            if (isOverflow) {
                Text(
                    text = value,
                    style = Type.textMdMedium(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.clickable {

                    }
                )
            } else {
                Text(
                    text = value,
                    style = Type.textMdMedium(),
                    maxLines = 2,
                )
            }
        }
    }
}