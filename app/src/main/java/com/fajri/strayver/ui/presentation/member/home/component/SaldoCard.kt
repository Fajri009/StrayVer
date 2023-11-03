package com.fajri.strayver.ui.presentation.member.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Neutral700
import com.fajri.strayver.ui.theme.Type

@Composable
fun SaldoCard(modifier: Modifier= Modifier) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Neutral50),
        elevation = CardDefaults.cardElevation(12.dp),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = R.drawable.ic_wallet, contentDescription = "", modifier = Modifier
                    .size(30.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Column() {
                Text(text = "Saldo", style = Type.textXsMedium())
                Text(text = "Rp 1.500.000", style = Type.textSmSemiBold(), color = Neutral700)
            }
        }
    }
}