package com.fajri.strayver.ui.presentation.relawan.profil.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.theme.Shades50

@Composable
fun RelawanProfilPicture(modifier: Modifier = Modifier, avatar: Any) {
    Card(
        modifier= modifier,
        colors = CardDefaults.cardColors(containerColor = Shades50),
        elevation = CardDefaults.cardElevation(12.dp),
        shape = CircleShape
    ) {
        AsyncImage(
            model = avatar,
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(5.dp)
                .size(120.dp)
                .clip(CircleShape)
        )
    }
}