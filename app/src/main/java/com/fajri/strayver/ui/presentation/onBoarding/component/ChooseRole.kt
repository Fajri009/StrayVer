package com.fajri.strayver.ui.presentation.onBoarding.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.presentation.component.CustomOutlinedButton
import com.fajri.strayver.ui.presentation.onBoarding.OnBoardViewModel
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Type
import kotlinx.coroutines.CoroutineScope

@Composable
fun ChooseRole(viewModel: OnBoardViewModel) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Masuk Sebagai", style = Type.textSmSemiBold(), color = Primary900)
        Spacer(modifier = Modifier.height(12.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            CustomOutlinedButton(
                onClick = {
                    viewModel.setOnBoardingCompleted()
                    viewModel.setAccountRole("relawan")
                },
                text = "Relawan",
                Modifier
                    .width(155.dp)
                    .height(48.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            CustomButton(
                onClick = {
                    viewModel.setOnBoardingCompleted()
                    viewModel.setAccountRole("member")
                },
                text = "Member",
                Modifier
                    .width(155.dp)
                    .height(48.dp)
            )
        }
    }
}