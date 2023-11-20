package com.fajri.strayver.ui.presentation.member.home.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.member.home.MemberHomeViewModel
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Type
import java.util.UUID

@Composable
fun Greet(modifier: Modifier= Modifier, nama: String) {

    Box(
        modifier= modifier
    ) {
        AsyncImage(
            model = R.drawable.ilustrasi,
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
        Column(
            Modifier
                .align(Alignment.CenterStart)
                .padding(start = 24.dp)) {
            Text(text = "Hi, $nama", style = Type.displayXsSemiBold(), color = Neutral50)
            Text(
                text = "Siap untuk berdonasi hari ini?",
                style = Type.textXsMedium(),
                color = Neutral50
            )
        }
    }
}