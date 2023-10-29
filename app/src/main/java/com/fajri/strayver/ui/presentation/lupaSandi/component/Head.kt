package com.fajri.strayver.ui.presentation.lupaSandi.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.Route

@Composable
fun Head(navController: NavController) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {
            navController.navigate(Route.LOGIN)
        }
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBackIos,
                contentDescription = "",
                tint = Neutral50,
            )
        }
        Text(
            text = "Lupa Sandi",
            style = Type.displayXsSemiBold(),
            color = Neutral50,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}