package com.fajri.strayver.ui.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import com.fajri.strayver.util.ButtonType

@Composable
fun CustomOutlinedButton(
    onClick: () -> Unit,
    text: String,
    type: String
) {
    when (type) {
        ButtonType.LARGE -> ButtonOutlineLarge(onClick = { onClick() }, text = text)
        ButtonType.MEDIUM -> ButtonOutlineMedium(onClick = { onClick() }, text = text)
        ButtonType.SMALL -> ButtonOutlineSmall(onClick = { onClick() }, text = text)
    }
}

@Composable
private fun ButtonOutlineLarge(
    onClick: () -> Unit,
    text: String,
) {
    OutlinedButton(
        onClick = {
            onClick()
        },
        border = BorderStroke(1.5.dp, Primary700),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .width(320.dp)
            .height(48.dp)
    ) {
        Text(text = text, style = Type.textSmSemiBold(), color = Primary700)
    }
}

@Composable
private fun ButtonOutlineMedium(
    onClick: () -> Unit,
    text: String,
) {
    OutlinedButton(
        onClick = {
            onClick()
        },
        border = BorderStroke(1.5.dp, Primary700),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .width(155.dp)
            .height(48.dp)
    ) {
        Text(text = text, style = Type.textSmSemiBold(), color = Primary700)
    }
}

@Composable
private fun ButtonOutlineSmall(
    onClick: () -> Unit,
    text: String,
) {
    OutlinedButton(
        onClick = {
            onClick()
        },
        border = BorderStroke(1.5.dp, Primary700),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .width(55.dp)
            .height(30.dp)
    ) {
        Text(text = text, style = Type.textSmSemiBold(), color = Primary700)
    }
}