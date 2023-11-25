package com.fajri.strayver.ui.presentation.relawan.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.model.DonasiData

@Composable
fun ContentRelawanHome(modifier: Modifier = Modifier, navController: NavController, donasiData: DonasiData) {
    Column(
        modifier = modifier
) {
        BuatProyek(modifier = Modifier.fillMaxWidth(), navController)
        Spacer(modifier = Modifier.height(30.dp))
        DonasiTerbaru(modifier = Modifier.fillMaxWidth(), navController, donasiData)
    }
}