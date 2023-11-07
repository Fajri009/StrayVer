package com.fajri.strayver.ui.presentation.relawan.buatProyek.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.Route

@Composable
fun BuatProyekHead(navController: NavController) {
    Row(
        modifier = Modifier.padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {
            navController.popBackStack()
            navController.navigate(Route.RELAWAN_HOME)
        }) {
            Icon(
                imageVector = Icons.Default.ArrowBackIos,
                contentDescription = "",
                tint = Shades50,
            )
        }
        Text(
            text = "Buat Proyek",
            color = Color.White,
            style = Type.displayXsSemiBold()
        )
    }
}