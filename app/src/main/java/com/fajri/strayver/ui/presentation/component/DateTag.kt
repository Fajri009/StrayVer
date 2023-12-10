package com.fajri.strayver.ui.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.fajri.strayver.ui.theme.Primary100
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Type

@Composable
fun DateTag(date: String) {
    Box(Modifier
        .clip(RoundedCornerShape(topEnd = 30.dp, bottomEnd = 30.dp))
        .background(Primary100)
        .padding(vertical = 2.dp, horizontal = 40.dp)
    ) {
        Text(text = date, style = Type.text2xsSemiBold(), color = Primary900)
    }
}