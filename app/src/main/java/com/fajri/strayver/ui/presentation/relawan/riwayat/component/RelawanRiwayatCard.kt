package com.fajri.strayver.ui.presentation.relawan.riwayat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.component.CompanyTag
import com.fajri.strayver.ui.theme.Neutral700
import com.fajri.strayver.ui.theme.Primary50
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Secondary50
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.ui.theme.Warning900
import com.fajri.strayver.util.DonaturProgres
import com.fajri.strayver.util.TipeDonasi

@Composable
fun RelawanRiwayatCard(
    tipe: String,
    companyIcon: Int,
    companyName: String,
    progres: String,
    judul: String,
    jumlah: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .background(
                    when (tipe) {
                        TipeDonasi.DANA -> Secondary50
                        TipeDonasi.BARANG -> Primary50
                        else -> Color.White
                    }, RoundedCornerShape(10.dp)
                )
                .padding(8.dp),
            model =
                when (tipe) {
                    TipeDonasi.DANA -> R.drawable.dana_icon
                    TipeDonasi.BARANG -> R.drawable.barang_icon
                    else -> R.drawable.anabul_foundation
                },
            contentDescription = "",
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column{
            Row {
                CompanyTag(companyName = companyName, companyIcon = companyIcon)
                Spacer(modifier = Modifier.width(5.dp))
                when (progres) {
                    DonaturProgres.PROSES -> ProgresProses()
                    DonaturProgres.SELESAI -> ProgresSelesai()
                }
            }
            Text(
                text = judul,
                color = Neutral700,
                style = Type.textXsSemiBold(),
                modifier = Modifier.fillMaxWidth(.7f)
            )
        }
        Text(
            text = jumlah,
            color = Primary900,
            style = Type.textSmSemiBold(),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End
        )
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
private fun ProgresProses() {
    Text(
        modifier = Modifier
            .border(1.dp, Warning900, RoundedCornerShape(5.dp))
            .padding(start = 5.dp, top = 1.dp, end = 5.dp),
        text = "Proses",
        color = Warning900,
        style = Type.text2xsRegular()
    )
}

@Composable
private fun ProgresSelesai() {
    Text(
        modifier = Modifier
            .border(1.dp, Primary900, RoundedCornerShape(5.dp))
            .padding(start = 5.dp, top = 1.dp, end = 5.dp),
        text = "Selesai",
        color = Primary900,
        style = Type.text2xsRegular()
    )
}