package com.fajri.strayver.ui.presentation.member.profil.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.presentation.component.CustomOutlinedButton
import com.fajri.strayver.ui.presentation.member.profil.MemberProfilViewModel
import com.fajri.strayver.ui.theme.Error900
import com.fajri.strayver.util.ButtonType
import com.fajri.strayver.util.Route

@Composable
fun OpsiButton(navController: NavController, viewModel: MemberProfilViewModel) {
    Row(
        Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        CustomOutlinedButton(
            onClick = {
                viewModel.logout()
                navController.popBackStack()
                navController.navigate(Route.LOGIN)
            },
            text = "Logout",
            type = ButtonType.MEDIUM,
            color = Error900
        )
        CustomButton(
            onClick = {
                navController.navigate(Route.MEMBER_EDIT_PROFIL)
            },
            text = "Edit",
            type = ButtonType.MEDIUM
        )
    }
}