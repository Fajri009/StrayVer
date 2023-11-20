package com.fajri.strayver.ui.presentation.relawan.profil.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.member.profil.component.OpsiButton
import com.fajri.strayver.ui.theme.Shades50

@Composable
fun RelawanProfilContent(navController: NavController) {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(top = 180.dp)
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Shades50)
            .padding(top = 80.dp, start = 20.dp, end = 20.dp)
    ) {
        item {
            RelawanInfoItem(value = "Anabul Foundation", title = "Nama", icon = R.drawable.ic_user)
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            RelawanInfoItem(value = "anabulz", title = "Username", icon = R.drawable.ic_card)
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            RelawanInfoItem(
                value = "Anabul Foundation merupakan komunitas relawan yang bergerak untuk menyelamatkan hewan-hewan terlantar dimana sudah berdiri sejak tahun 2010.\n",
                title = "Deskripsi",
                icon = R.drawable.ic_info,
                isOverflow = true
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            RelawanInfoItem(value = "anabul.foundation@gmail.com", title = "Email", icon = R.drawable.ic_email)
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            RelawanInfoItem(
                value = "Jl Veteran no 8, Ketawanggede, Malang",
                title = "Alamat",
                icon = R.drawable.ic_location
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            RelawanInfoItem(value = "08519081945", title = "Nomer Telepon", icon = R.drawable.ic_phone)
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            RelawanInfoItem(value = "Relawan", title = "Role", icon = R.drawable.ic_role)
        }

        item {
            Spacer(modifier = Modifier.height(32.dp))
            RelawanProfilOpsiButton(navController)
            Spacer(modifier = Modifier.height(70.dp))
        }
    }
}