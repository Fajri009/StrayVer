package com.fajri.strayver.ui.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.fajri.strayver.ui.theme.Neutral200
import com.fajri.strayver.ui.theme.Primary700

@Composable
fun CustomProgressBar(progress: Float) {
    LinearProgressIndicator(
        color = Primary700,
        trackColor = Neutral200,
        progress = 0.3f,
        modifier = Modifier
            .fillMaxWidth()
            .height(6.dp)
            .clip(CircleShape)
    )
}