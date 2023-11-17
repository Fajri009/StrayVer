package com.fajri.strayver.ui.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.fajri.strayver.ui.theme.Primary100
import com.fajri.strayver.ui.theme.Primary400
import com.fajri.strayver.ui.theme.Primary800
import com.fajri.strayver.ui.theme.Primary900

@Composable
fun CustomTextField(
    text: String,
    placeholder: String,
    trailingIcon: ImageVector? = null,
    showPassword: Boolean = false,
    onValueChange: (String) -> Unit = {},
    onPasswordToggle: (Boolean) -> Unit = {},
    label: String? = null,
    isPassword: Boolean = false,
    isNumeric: Boolean= false,
    maxLine: Int = 1,
    minLine: Int = 1,
    onIconClick: () -> Unit= {},
    modifier: Modifier= Modifier.fillMaxWidth()
) {
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = {
            onValueChange(it)
        },
        placeholder = {
            Text(text = placeholder)
        },
        trailingIcon = {
            if (trailingIcon != null) {
                if (showPassword) {
                    IconButton(onClick = { onPasswordToggle(!showPassword) }) {
                        Icon(
                            imageVector = trailingIcon,
                            contentDescription = "show",
                            Modifier.size(25.dp),
                            tint = Primary900
                        )
                    }
                    IconButton(onClick = { onPasswordToggle(!showPassword) }) {
                        Icon(
                            imageVector = Icons.Filled.VisibilityOff,
                            contentDescription = "hide",
                            Modifier.size(25.dp),
                            tint = Primary900
                        )
                    }
                } else {
                    IconButton(onClick = { onIconClick() }) {
                        Icon(
                            imageVector = trailingIcon,
                            contentDescription = "hide",
                            Modifier.size(25.dp),
                            tint = Primary900
                        )
                    }
                }
            }
        },
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Primary100,
            unfocusedIndicatorColor = Primary400,
            focusedIndicatorColor = Primary800,
            cursorColor = Primary900,
            textColor = Color.Black,
            placeholderColor = Primary800
        ),
        label = {
            label?.let {
                Text(text = it)
            }
        },
        visualTransformation =
        if (isPassword) {
            if (showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            }
        } else {
            VisualTransformation.None
        },
        keyboardOptions =
        if (isPassword) {
            KeyboardOptions(keyboardType = KeyboardType.Password)
        } else if (isNumeric) {
            KeyboardOptions(keyboardType = KeyboardType.Number)
        }
        else {
            KeyboardOptions(keyboardType = KeyboardType.Text)
        },
        maxLines = maxLine,
        minLines = minLine
    )
}