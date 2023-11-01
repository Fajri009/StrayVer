package com.fajri.strayver.ui.presentation.relawan.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.unit.dp
import com.fajri.strayver.ui.presentation.member.home.component.Greet
import com.fajri.strayver.ui.presentation.member.home.component.SaldoCard
import com.fajri.strayver.ui.presentation.relawan.home.component.DonasiCard
import com.fajri.strayver.ui.presentation.relawan.home.component.RelawanGreet
import com.fajri.strayver.ui.theme.Primary700

@Composable
fun RelawanHomeScreen() {
    Column {
        Box(Modifier.fillMaxSize()) {
            RelawanGreet(
                Modifier
                    .fillMaxWidth()
                    .height(178.dp)
                    .clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
                    .background(Primary700)
            )
            DonasiCard(
                Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = 120.dp)
                    .padding(start = 30.dp, end = 30.dp)
            )
        }
    }
}