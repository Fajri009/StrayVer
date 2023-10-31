package com.fajri.strayver.ui.presentation.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Type
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, viewModel: SplashViewModel= hiltViewModel()) {

    val alphaAnim = animateFloatAsState(
        targetValue = if (viewModel.isLoading.value) 1f else 0f,
        animationSpec = tween(
            durationMillis = 2000
        )
    )

    LaunchedEffect(key1 = true) {
        viewModel.changeLoadingState(true)
        delay(3000)
        navController.popBackStack()
        navController.navigate(viewModel.nextDestination.value)
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Primary700),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = R.drawable.logo,
            contentDescription = "",
            modifier = Modifier.alpha(alphaAnim.value).size(200.dp),
        )
        Text(text = "StrayVer", color = Color.White, style = Type.displayLgSemiBold(), modifier =
        Modifier.alpha(alphaAnim.value))
    }
}