package com.fajri.strayver.ui.presentation.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.component.LoadingDialog
import com.fajri.strayver.ui.presentation.register.component.RegisterForm
import com.fajri.strayver.ui.presentation.register.component.RegisterHead
import com.fajri.strayver.ui.presentation.register.component.RegisterPopup
import com.fajri.strayver.ui.theme.Primary700

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    
    val context= LocalContext.current
    val scope= rememberCoroutineScope()

    if (viewModel.isLoading.value) {
        LoadingDialog()
    }
    
    if (viewModel.isShowDialog.value) {
        RegisterPopup(navController = navController)
    }
    
    Box(
        Modifier
            .fillMaxSize()
            .background(Primary700)
    ) {
        AsyncImage(
            model = R.drawable.ilustrasi,
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )

        Column {
            RegisterHead(navController = navController)
            RegisterForm(viewModel = viewModel, navController = navController, context= context,
                scope)
        }
    }
}