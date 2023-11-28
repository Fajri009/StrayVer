package com.fajri.strayver.ui.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
fun CustomButton(
    onClick: () -> Unit,
    text: String,
    type: String,
    modifier: Modifier = Modifier
) {
    when (type) {
        ButtonType.LARGE -> ButtonLarge(onClick = { onClick() }, text = text, modifier)
        ButtonType.MEDIUM -> ButtonMedium(onClick = { onClick() }, text = text, modifier)
        ButtonType.SMALL -> ButtonSmall(onClick = { onClick() }, text = text, modifier)
    }
}

@Composable
private fun ButtonLarge(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(containerColor = Primary700),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
    ) {
        Text(
            text = text,
            style = Type.textSmSemiBold(),
            color = Shades50
        )
    }
}

@Composable
private fun ButtonMedium(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(containerColor = Primary700),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .height(48.dp)
            .sizeIn(minWidth = 155.dp)
    ) {
        Text(
            text = text,
            style = Type.textSmSemiBold(),
            color = Shades50
        )
    }
}

@Composable
private fun ButtonSmall(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(containerColor = Primary700),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .width(55.dp)
            .height(30.dp)
    ) {
        Text(
            text = text,
            style = Type.textSmSemiBold(),
            color = Shades50
        )
    }
}