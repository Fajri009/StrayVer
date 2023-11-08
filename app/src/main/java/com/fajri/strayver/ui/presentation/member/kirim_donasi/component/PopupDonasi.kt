package com.fajri.strayver.ui.presentation.member.kirim_donasi.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.ButtonType

@Composable
fun PopupDonasi(navController: NavController) {
    Dialog(onDismissRequest = { /*TODO*/ }) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = R.drawable.popup_register,
                contentDescription = "",
                Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Donasi Sukses", style = Type.textLgSemiBold(), color = Primary900)
            Text(
                text = "Terima kasih telah mendonasikan danamu",
                style = Type.textLgSemiBold(),
                color = Primary900,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomButton(onClick = { /*TODO*/ }, text = "Baik", type = ButtonType.MEDIUM)
        }
    }
}