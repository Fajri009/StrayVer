package com.fajri.strayver.ui.presentation.relawan.tambahDonasi.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fajri.strayver.ui.theme.Error900
import com.fajri.strayver.ui.theme.Neutral800
import com.fajri.strayver.ui.theme.Primary300
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Secondary900
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.ui.theme.Warning900
import com.fajri.strayver.util.DonaturProgres

@Composable
fun TambahDonasiItem(
    foto: Int,
    tanggal: String,
    progres: String,
    nama: String,
    jumlah: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable {
                onClick()
            }
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape),
                model = foto,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = tanggal,
                        color = Neutral800,
                        style = Type.text2xsRegular()
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    when (progres) {
                        DonaturProgres.PROSES -> ProgresProses()
                        DonaturProgres.SELESAI -> ProgresSelesai()
                        DonaturProgres.DIBATALKAN -> ProgresBatal()
                    }
                }
                Text(
                    text = nama,
                    color = Neutral800,
                    style = Type.textSmSemiBold()
                )
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = jumlah,
                color = Secondary900,
                style = Type.textSmSemiBold(),
                textAlign = TextAlign.End
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Primary300
        )
    }
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

@Composable
private fun ProgresBatal() {
    Text(
        modifier = Modifier
            .border(1.dp, Error900, RoundedCornerShape(5.dp))
            .padding(start = 5.dp, top = 1.dp, end = 5.dp),
        text = "Dibatalkan",
        color = Error900,
        style = Type.text2xsRegular()
    )
}