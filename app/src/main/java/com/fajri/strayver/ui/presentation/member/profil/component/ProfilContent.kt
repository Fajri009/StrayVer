package com.fajri.strayver.ui.presentation.member.profil.component

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
import com.fajri.strayver.ui.presentation.member.profil.MemberProfilViewModel
import com.fajri.strayver.ui.theme.Shades50

@Composable
fun ProfilContent(userData: UserData, navController: NavController, viewModel: MemberProfilViewModel) {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(top = 180.dp)
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Shades50)
            .padding(horizontal = 20.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(60.dp))
            InfoItem(value = userData.nama, title = "Nama", icon = R.drawable.ic_user)
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            InfoItem(value = userData.username, title = "Username", icon = R.drawable.ic_card)
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            InfoItem(value = userData.email, title = "Email", icon = R.drawable.ic_email)
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            InfoItem(
                value = userData.alamat,
                title = "Alamat",
                icon = R.drawable.ic_location
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            InfoItem(value = userData.telp, title = "Nomer Telepon", icon = R.drawable.ic_phone)
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            InfoItem(value = userData.role, title = "Role", icon = R.drawable.ic_role)
        }

        item {
            Spacer(modifier = Modifier.height(32.dp))
            OpsiButton(navController, viewModel)
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}