package com.fajri.strayver.ui.presentation.relawan.editProfil.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.presentation.component.CustomTextField
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.ButtonType
import com.fajri.strayver.util.Route

@Composable
fun RelawanEditProfilContent(navController: NavController) {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(top = 180.dp)
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Shades50)
            .padding(top = 80.dp, start = 20.dp, end = 20.dp)
    ) {

        item {
            Text(text = "Nama Relawan / Komunitas", style = Type.textSmMedium())
            CustomTextField(text = "", placeholder = "")
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Text(text = "Username", style = Type.textSmMedium())
            CustomTextField(text = "", placeholder = "")
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Text(text = "Deskripsi", style = Type.textSmMedium())
            CustomTextField(text = "", placeholder = "", minLine = 6, maxLine = 6)
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Text(text = "Email", style = Type.textSmMedium())
            CustomTextField(text = "", placeholder = "")
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Text(text = "Alamat", style = Type.textSmMedium())
            CustomTextField(text = "", placeholder = "")
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Text(text = "Nomer Telepon", style = Type.textSmMedium())
            CustomTextField(text = "", placeholder = "")
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Text(text = "Password", style = Type.textSmMedium())
            CustomTextField(text = "", placeholder = "", isPassword = true, trailingIcon = Icons.Default.VisibilityOff)
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            CustomButton(
                onClick = {
                    navController.navigate(Route.RELAWAN_PROFIL)
                },
                text = "Simpan",
                type = ButtonType.LARGE
            )
            Spacer(modifier = Modifier.height(70.dp))
        }
    }
}