package com.fajri.strayver.ui.presentation.component

import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fajri.strayver.ui.theme.Primary700

@Composable
fun CustomRadioButton(
    isSelected: Boolean= false,
    onClick: (Boolean) -> Unit= {}
) {
    RadioButton(
        selected = isSelected,
        onClick = {

        },
        colors = RadioButtonDefaults.colors(
            selectedColor = Primary700,
            unselectedColor = Primary700
        ),
        modifier = Modifier.sizeIn(maxWidth = 20.dp, maxHeight = 20.dp)
    )
}