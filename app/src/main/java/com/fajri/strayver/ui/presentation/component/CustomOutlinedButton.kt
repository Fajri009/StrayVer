package com.fajri.strayver.ui.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type

@Composable
fun CustomOutlinedButton(onClick: () -> Unit, text: String, modifier: Modifier= Modifier.fillMaxWidth()) {
    OutlinedButton(
        onClick = {
            onClick()
        },
        border = BorderStroke(1.5.dp, Primary700),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
    ) {
        Text(text = text, style = Type.textSmSemiBold(), color = Primary700)
    }
}