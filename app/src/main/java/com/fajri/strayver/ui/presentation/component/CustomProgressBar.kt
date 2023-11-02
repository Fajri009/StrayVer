package com.fajri.strayver.ui.presentation.component

import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import com.fajri.strayver.ui.theme.Neutral200
import com.fajri.strayver.ui.theme.Primary700

@Composable
fun CustomProgressBar(progress: Float) {
    LinearProgressIndicator(
        color = Neutral200,
        trackColor = Primary700,
        progress = 31f
    )
}