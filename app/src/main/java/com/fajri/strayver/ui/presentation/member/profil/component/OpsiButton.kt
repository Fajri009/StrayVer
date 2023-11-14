package com.fajri.strayver.ui.presentation.member.profil.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.presentation.component.CustomOutlinedButton
import com.fajri.strayver.ui.theme.Error900
import com.fajri.strayver.util.ButtonType

@Composable
fun OpsiButton() {
    Row(
        Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        CustomOutlinedButton(
            onClick = { /*TODO*/ },
            text = "Logout",
            type = ButtonType.MEDIUM,
            color = Error900
        )
        CustomButton(onClick = { /*TODO*/ }, text = "Edit", type = ButtonType.MEDIUM)
    }
}