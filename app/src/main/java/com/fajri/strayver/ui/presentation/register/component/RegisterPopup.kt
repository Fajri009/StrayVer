package com.fajri.strayver.ui.presentation.register.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.ButtonType
import com.fajri.strayver.util.Route

@Composable
fun RegisterPopup(navController: NavController) {
    Dialog(onDismissRequest = { /*TODO*/ }) {
        Dialog(onDismissRequest = { }) {
            Column(
                Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .background(Neutral50)
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = R.drawable.popup_register, contentDescription = "", modifier =
                    Modifier.size(150.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Sukses", style = Type.textLgSemiBold(), color = Primary900)
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Selamat, akunmu sudah terdaftar.",
                    style = Type.textXsRegular(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                CustomButton(
                    onClick = {
                        navController.navigate(Route.LOGIN)
                    },
                    text = "Baik",
                    type = ButtonType.MEDIUM
                )
            }
        }
    }
}