package com.fajri.strayver.ui.presentation.member.kirim_donasi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.presentation.member.kirim_donasi.component.MetodePembayaran
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.ButtonType
import com.fajri.strayver.util.Route

@Composable
fun KirimDonasiScreen(navController: NavController) {

    val type = "dana"

    when (type) {
        "dana" -> KirimDana(navController)
        "barang" -> KirimBarang()
    }
}

@Composable
private fun KirimDana(navController: NavController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Primary700)
    ) {
        AsyncImage(model = R.drawable.ilustrasi, contentDescription = "")
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            IconButton(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Route.DETAIL_DONASI)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "",
                    tint = Shades50
                )
            }
            Text(text = "Donasi Dana", style = Type.displayXsSemiBold(), color = Shades50)

        }
        Column(Modifier.align(Alignment.TopStart)) {
            Spacer(modifier = Modifier.height(40.dp))
            MetodePembayaran(
                navController,
                Modifier
                    .padding(top = 60.dp)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(Neutral50)
                    .padding(20.dp)
            )
        }

        Column(Modifier.align(Alignment.BottomCenter).padding(20.dp)) {
            CustomButton(onClick = { /*TODO*/ }, text = "Kirim", type = ButtonType.LARGE)
        }
    }
}

@Composable
private fun KirimBarang() {

}