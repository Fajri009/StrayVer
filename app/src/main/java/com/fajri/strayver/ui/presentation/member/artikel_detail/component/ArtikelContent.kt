package com.fajri.strayver.ui.presentation.member.artikel_detail.component

import android.graphics.Paint.Style
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.theme.Neutral600
import com.fajri.strayver.ui.theme.Neutral800
import com.fajri.strayver.ui.theme.Neutral900
import com.fajri.strayver.ui.theme.Primary300
import com.fajri.strayver.ui.theme.Primary400
import com.fajri.strayver.ui.theme.Primary800
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type
import java.time.LocalDate

@Composable
fun ArtikelContent() {
    val deskripsi = "Dalam sebuah kisah yang penuh empati, relawan strayver bersatu untuk menyelamatkan puluhan kucing yang ditinggalkan setelah pemiliknya, Isabella, meninggal dunia. Isabella, seorang wanita penyayang binatang, meninggalkan warisan hewan-hewan yang tak memiliki tempat untuk pergi setelah kepergiannya. Tim Penyelamat Hewan, dipimpin oleh seorang perempuan bernama Emma, tampil sebagai pahlawan tanpa kostum, siap memberikan perlindungan dan kasih sayang kepada makhluk-makhluk yang ditinggalkan ini.\n" +
            "Ketika tim tersebut tiba di rumah Isabella, mereka dihadapkan pada pemandangan yang menyayat hati: puluhan kucing yang bingung dan takut, mencari kehangatan yang tidak lagi ada. Dengan tekun, tim ini melaksanakan evakuasi kucing-kucing ke tempat penampungan sementara, memberikan mereka perawatan medis dan lingkungan yang aman. Berita tentang aksi penyelamatan ini menyebar dengan cepat di media sosial, membangkitkan dukungan dari masyarakat yang tergerak oleh kebaikan hati mereka.\n" +
            "Proses pemulihan kucing-kucing ini bukan hanya menyediakan tempat perlindungan baru bagi mereka, tetapi juga mengajarkan kita semua tentang tanggung jawab kita terhadap hewan peliharaan. Melalui tindakan empati dan kebaikan hati, Tim Penyelamat Hewan menceritakan kisah inspiratif tentang bagaimana cinta dan perhatian dapat membuat perbedaan besar dalam kehidupan makhluk-makhluk yang rentan, membawa harapan dan kebahagiaan kembali ke dalam mata mereka yang dulu dipenuhi kebingungan dan ketakutan."
    LazyColumn(
        Modifier
            .fillMaxSize()
            .clip(
                RoundedCornerShape(
                    topStart = 30.dp, topEnd = 30.dp
                )
            )
            .background(Shades50)
            .padding(20.dp)
    ) {
        item {
            Text(
                text = "Rescue Puluhan Kucing yang Ditinggal Pemiliknya Meninggal Dunia",
                style = Type.textMdSemiBold(),
                color = Primary900
            )
            Spacer(modifier = Modifier.height(15.dp))
        }
        item {
            PosterTag(avatar = "", nama = "Sasha Brauss", waktu = LocalDate.now())
            Spacer(modifier = Modifier.height(15.dp))
            Divider(color = Primary300, thickness = 1.5.dp)
        }
        item {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = deskripsi,
                style = Type.textXsRegular(),
                color = Neutral800
            )
        }
    }
}

@Composable
private fun PosterTag(avatar: String, nama: String, waktu: LocalDate) {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            model = R.drawable.avatar,
            contentDescription = "",
            modifier = Modifier
                .size(45.dp)
                .clip(CircleShape)
        )
        Column (){
            Text(text = nama, style = Type.textXsSemiBold(), color = Neutral900)
            Text(text = waktu.toString(), style = Type.text2xsRegular(), color = Neutral600)
        }
    }
}

