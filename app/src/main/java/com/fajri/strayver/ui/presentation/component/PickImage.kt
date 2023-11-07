package com.fajri.strayver.ui.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.theme.Primary50
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.util.ButtonType

@Composable
fun PickImage() {

    val stroke = Stroke(
        width = 2f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    )

    Column(
        Modifier
            .fillMaxWidth()
            .background(Primary50)
            .drawBehind {
                drawRoundRect(
                    color = Primary700,
                    style = stroke,
                    cornerRadius = CornerRadius(15.dp.toPx())
                )
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AsyncImage(
            model = R.drawable.ic_file,
            contentDescription = "",
            modifier = Modifier.size(width = 16.dp, height = 16.dp)
        )
        Spacer(modifier = Modifier.height(6.dp))
        CustomButton(onClick = { /*TODO*/ }, text = "Unggah Gambar", type = ButtonType.MEDIUM)
    }
}