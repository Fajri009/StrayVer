package com.fajri.strayver.ui.presentation.member.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.member.home.component.Greet
import com.fajri.strayver.ui.presentation.member.home.component.ProyekTerbaru
import com.fajri.strayver.ui.presentation.member.home.component.SaldoCard
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Type

@Composable
fun MemberHomeScreen() {
    Column {
        Box(Modifier.fillMaxWidth()) {
            Greet(
                Modifier
                    .fillMaxWidth()
                    .height(178.dp)
                    .clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
                    .background(Primary700)
            )
            SaldoCard(
                Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = 150.dp)
            )
        }
        Spacer(modifier = Modifier.height(56.dp))
        ProyekTerbaru()
    }
}