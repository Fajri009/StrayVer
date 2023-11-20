package com.fajri.strayver.ui.presentation.member.edit_profil

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.component.LoadingDialog
import com.fajri.strayver.ui.presentation.member.edit_profil.component.EditProfilContent
import com.fajri.strayver.ui.presentation.component.ProfilePicture
import com.fajri.strayver.ui.presentation.member.edit_profil.component.EditProfilMemberViewModel
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.Route

@Composable
fun EditProfilMemberScreen(navController: NavController, viewModel: EditProfilMemberViewModel=
    hiltViewModel()) {

    val userData by viewModel.userData
    val scope= rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        viewModel.getUserData()
    }

    if (viewModel.isLoading.value) {
        LoadingDialog()
    }

    Box(
        Modifier
            .fillMaxSize()
            .background(Primary700)
    ) {
        AsyncImage(model = R.drawable.ilustrasi2, contentDescription = "")
        Row(
            Modifier
                .align(Alignment.TopCenter)
                .offset(y = 60.dp)
                .clip(CircleShape)
                .background(Shades50)
                .padding(vertical = 4.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            IconButton(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Route.MEMBER_PROFIL)
                },
                modifier = Modifier.size(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "",
                    tint = Primary700,
                    modifier = Modifier
                        .padding(bottom = 3.dp)
                        .size(16.dp)
                        .clip(CircleShape)
                )
            }

            Text(
                text = "Edit Profil",
                style = Type.textLgBold(),
                color = Primary700,
            )
        }

        Column(Modifier.align(Alignment.TopStart)) {
            EditProfilContent(viewModel, scope, navController)
        }

        ProfilePicture(
            Modifier
                .align(Alignment.TopCenter)
                .offset(y = 115.dp)
        )

        EditButton(
            Modifier
                .align(Alignment.TopCenter)
                .offset(y = 200.dp, x = 50.dp)
                .size(30.dp)

        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EditButton(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = CircleShape,
        colors = CardDefaults.cardColors(containerColor = Shades50),
        onClick = {},
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        AsyncImage(
            model = R.drawable.ic_edit,
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
    }
}