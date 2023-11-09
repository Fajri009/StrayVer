package com.fajri.strayver.ui.presentation.relawan.donasi.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fajri.strayver.ui.presentation.component.CustomTextField
import com.fajri.strayver.ui.theme.Type

@Composable
fun RelawanDonasiHead() {
    Spacer(modifier = Modifier.height(55.dp))
    Text(
        modifier = Modifier.padding(start = 20.dp),
        text = "Proyek Donasimu",
        color = Color.White,
        style = Type.displayXsSemiBold()
    )
    Spacer(modifier = Modifier.height(5.dp))
    Column(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp)
    ) {
        CustomTextField(
            text = "",
            placeholder = "Search",
            label = "Search",
        )
    }
    Spacer(modifier = Modifier.height(22.dp))
}