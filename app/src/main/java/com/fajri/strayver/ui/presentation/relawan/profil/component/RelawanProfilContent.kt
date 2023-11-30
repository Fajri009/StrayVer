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
import com.fajri.strayver.model.UserData
import com.fajri.strayver.ui.presentation.member.profil.component.OpsiButton
import com.fajri.strayver.ui.theme.Shades50

@Composable
fun RelawanProfilContent(userData: UserData,navController: NavController) {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(top = 180.dp)
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Shades50)
            .padding(top = 80.dp, start = 20.dp, end = 20.dp)
    ) {
        item {
            RelawanInfoItem(value = userData.nama, title = "Nama", icon = R.drawable.ic_user)
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            RelawanInfoItem(value = userData.username, title = "Username", icon = R.drawable.ic_card)
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            RelawanInfoItem(
                value =
                    if (userData.deskripsi != "") {
                        userData.deskripsi
                    } else {
                        "-"
                    },
                title = "Deskripsi",
                icon = R.drawable.ic_info,
                isOverflow = true
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            RelawanInfoItem(value = userData.email, title = "Email", icon = R.drawable.ic_email)
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            RelawanInfoItem(
                value = userData.alamat ,
                title = "Alamat",
                icon = R.drawable.ic_location
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            RelawanInfoItem(value = userData.telp, title = "Nomer Telepon", icon = R.drawable.ic_phone)
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