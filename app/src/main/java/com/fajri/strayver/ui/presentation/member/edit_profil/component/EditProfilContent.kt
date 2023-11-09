package com.fajri.strayver.ui.presentation.member.edit_profil.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.presentation.component.CustomTextField
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.ButtonType

@Composable
fun EditProfilContent() {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(top = 180.dp)
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Shades50)
            .padding(top = 70.dp, start = 20.dp, end = 20.dp, bottom = 80.dp)
    ) {
        
        item {
            Text(text = "Nama Lengkap", style = Type.textSmMedium())
            CustomTextField(text = "", placeholder = "")
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Text(text = "Username", style = Type.textSmMedium())
            CustomTextField(text = "", placeholder = "")
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
            CustomTextField(text = "", placeholder = "", isPassword = true)
            Spacer(modifier = Modifier.height(8.dp))
        }
        
        item { 
            Spacer(modifier = Modifier.height(16.dp))
            CustomButton(onClick = { /*TODO*/ }, text = "Simpan", type = ButtonType.LARGE)
        }
    }
}