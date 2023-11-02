package com.fajri.strayver.ui.presentation.member.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.component.CustomProgressBar
import com.fajri.strayver.ui.theme.Neutral600
import com.fajri.strayver.ui.theme.Type

@Composable
fun ProyekCard() {
    Card(
        shape = RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {

        AsyncImage(
            model = R.drawable.kucing_makan,
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                AsyncImage(model = R.drawable.anabul_foundation, contentDescription = "")
                Text(text = "Anabul Foundation", style = Type.text2xsRegular(), color = Neutral600)
            }
            Spacer(modifier = Modifier.height(3.dp))
            Text(text = "Selamatkan ratusan kucing kelaparan", style = Type.textXsSemiBold(),
                modifier = Modifier.widthIn(max = 181.dp))

            Spacer(modifier = Modifier.height(3.dp))
            CustomProgressBar(progress = 31f)
        }
    }
}