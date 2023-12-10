package com.fajri.strayver.ui.presentation.component

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
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
import com.fajri.strayver.ui.presentation.relawan.buatProyek.BuatProyekViewModel
import com.fajri.strayver.ui.theme.Neutral500
import com.fajri.strayver.ui.theme.Primary50
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.ButtonType

@Composable
fun PickImageBuatProyek(viewModel: BuatProyekViewModel) {
    val stroke = Stroke(
        width = 2f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    )

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            it?.let {
                viewModel.setImageUri(it)
            }
        }
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
            }
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if(viewModel.imageUri.value != null) {
            AsyncImage(
                model = viewModel.imageUri.value,
                contentDescription = "",
            )
        } else {
            AsyncImage(
                model = R.drawable.ic_file,
                contentDescription = "",
                modifier = Modifier.size(40.dp)
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        CustomButton(
            onClick = {
                launcher.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )
            },
            text = "Unggah Gambar",
            type = ButtonType.MEDIUM
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Format yang didukung : JPEG, PNG",
            style = Type.textXsMedium(),
            color = Neutral500
        )
    }
}