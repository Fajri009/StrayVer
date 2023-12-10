package com.fajri.strayver.ui.presentation.member.detail_donasi.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
                                    import com.fajri.strayver.model.Donasi
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Type

@Composable
fun ContentDescription(donasi: Donasi) {


    Column() {
        Text(text = "Deskripsi :", style = Type.textMdSemiBold(), color = Primary900)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text ="${donasi.deskripsi}", style = Type.textSmRegular())

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Alamat :", style = Type.textMdSemiBold(), color = Primary900)
        Text(text = donasi.alamat, style = Type.textSmRegular())
        Spacer(modifier = Modifier.height(16.dp))
    }
}