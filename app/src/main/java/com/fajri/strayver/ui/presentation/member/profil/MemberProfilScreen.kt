package com.fajri.strayver.ui.presentation.member.profil

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.component.ProfilePicture
import com.fajri.strayver.ui.presentation.member.profil.component.OpsiButton
import com.fajri.strayver.ui.presentation.member.profil.component.ProfilContent
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type

@Composable
fun MemberProfilScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .background(Primary700)
    ) {
        AsyncImage(model = R.drawable.ilustrasi2, contentDescription = "")
        Box(
            Modifier
                .align(Alignment.TopCenter)
                .offset(y = 60.dp)
                .clip(CircleShape)
                .background(Shades50)
                .padding(vertical = 4.dp, horizontal = 32.dp)
        ) {
            Text(
                text = "Profil",
                style = Type.textLgBold(),
                color = Primary700,
            )
        }

        Column(Modifier.align(Alignment.TopStart)) {
            ProfilContent()
        }

        ProfilePicture(
            Modifier
                .align(Alignment.TopCenter)
                .offset(y = 115.dp)
        )
    }
}