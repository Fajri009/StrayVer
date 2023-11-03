package com.fajri.strayver.ui.presentation.register.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fajri.strayver.ui.presentation.member.home.component.DonasiTerbaru
import com.fajri.strayver.ui.presentation.relawan.home.component.BuatProyek

@Composable
fun ContentRelawanHome(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        BuatProyek(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(30.dp))
        DonasiTerbaru(modifier = Modifier.fillMaxWidth())
    }
}