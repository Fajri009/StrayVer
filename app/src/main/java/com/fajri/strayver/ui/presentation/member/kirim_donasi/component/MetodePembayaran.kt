package com.fajri.strayver.ui.presentation.member.kirim_donasi.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.component.CustomRadioButton
import com.fajri.strayver.ui.presentation.component.CustomTextField
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Primary100
import com.fajri.strayver.ui.theme.Primary800
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type

@Composable
fun MetodePembayaran(navController: NavController, modifier: Modifier= Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(text = "Masukkan Nominal Donasi", style = Type.textSmSemiBold())
        CustomTextField(
            text = "",
            placeholder = "",
            isNumeric = true,
            onValueChange = {

            }
        )

        Spacer(modifier = Modifier.height(20.dp))
        Card(
            colors = CardDefaults.cardColors(Primary100),
            elevation = CardDefaults.cardElevation(6.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Metode Pembayaran",
                style = Type.textSmBold(),
                color = Primary800,
                modifier = Modifier.padding(16.dp)
            )

            Column(
                Modifier
                    .padding(2.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Shades50)
                    .padding(horizontal = 32.dp, vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.clickable {

                        }
                    ) {
                        AsyncImage(
                            model = R.drawable.ic_wallet,
                            contentDescription = "",
                            modifier = Modifier.sizeIn(maxHeight = 22.dp, maxWidth = 22.dp)
                        )
                        Text(text = "Saldo Strayver", style = Type.textSmMedium())
                    }
                    CustomRadioButton()
                }

                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.clickable {

                        }
                    ) {
                        AsyncImage(
                            model = R.drawable.ic_gopay,
                            contentDescription = "",
                            modifier = Modifier.sizeIn(maxHeight = 22.dp, maxWidth = 22.dp)
                        )
                        Text(text = "Gopay", style = Type.textSmMedium())
                    }
                    CustomRadioButton()
                }

                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.clickable {

                        }
                    ) {
                        AsyncImage(
                            model = R.drawable.ic_dana,
                            contentDescription = "",
                            modifier = Modifier.sizeIn(maxHeight = 22.dp, maxWidth = 22.dp)
                        )
                        Text(text = "Dana", style = Type.textSmMedium())
                    }
                    CustomRadioButton()
                }
            }
        }
    }
}