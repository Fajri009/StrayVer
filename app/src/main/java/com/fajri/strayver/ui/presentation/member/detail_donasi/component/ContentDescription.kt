package com.fajri.strayver.ui.presentation.member.detail_donasi.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Type

@Composable
fun ContentDescription() {
    Column {
        Text(text = "Deskripsi :", style = Type.textMdSemiBold(), color = Primary900)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Kami sangat membutuhkan 12 kandang untuk menampung kucing dan anjing yang " +
                "terkena musibah banjir lorem ipsum dolor amet lorem ipsum dolor amet lorem ipsum" +
                " dolor amet lorem ipsum dolor amet lorem ipsum dolor amet lorem ipsum dolor amet" +
                " lorem ipsum dolor amet lorem ipsum dolor amet", style = Type.textSmRegular())

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Alamat Tujuan :", style = Type.textMdSemiBold(), color = Primary900)
        Text(text = "Jl Veteran bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla " +
                "bla bla bla bla bla", style = Type.textSmRegular())
        
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Ketentuan", style = Type.textMdSemiBold(), color = Primary900)
        Text(text = " 1.\tKirim ke alamat di atas melalui ekspedisi pilihanmu\n" +
                "2.\tMasukkan nomor resi dan bla bla bla", style = Type.textSmRegular())
    }
}