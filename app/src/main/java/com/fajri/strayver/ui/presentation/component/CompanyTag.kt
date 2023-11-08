package com.fajri.strayver.ui.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fajri.strayver.ui.theme.Neutral600
import com.fajri.strayver.ui.theme.Type

@Composable
fun CompanyTag(
    companyName: String,
    companyIcon: Int,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = companyIcon,
            contentDescription = companyName,
            modifier = Modifier
                .size(12.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(text = companyName, style = Type.text2xsRegular(), color = Neutral600)
    }
}