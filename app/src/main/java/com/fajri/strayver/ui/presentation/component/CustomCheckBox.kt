package com.fajri.strayver.ui.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fajri.strayver.ui.theme.Primary400
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Primary800

@Composable
fun CustomCheckBox (
    onClick: () -> Unit = {},
    isClicked: Boolean = false
) {
    Box(
        modifier = Modifier
            .size(20.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(
                if (isClicked) {
                    Primary800
                } else {
                    Color.White
                }
            )
            .border(width = 1.dp, color = Primary700, shape = RoundedCornerShape(5.dp))
            .clickable {
                onClick()
            }
    ) {
        Icon(imageVector = Icons.Default.Check, contentDescription = "checklist", tint = Color.White)
    }
}

