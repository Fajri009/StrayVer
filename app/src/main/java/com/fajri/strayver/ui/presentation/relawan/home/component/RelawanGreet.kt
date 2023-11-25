package com.fajri.strayver.ui.presentation.relawan.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.model.UserData
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Type

@Composable
fun RelawanGreet(modifier: Modifier = Modifier, userData: UserData) {
    Box(
        modifier = modifier
    ) {
        AsyncImage(
            model = R.drawable.ilustrasi,
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 24.dp)
        ) {
            Text(
                text = "Hi, ${userData.username}",
                style = Type.displayXsSemiBold(),
                color = Neutral50
            )
        }
    }
}