package com.fajri.strayver.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fajri.strayver.ui.presentation.login.LoginScreen
import com.fajri.strayver.ui.presentation.onBoarding.OnBoardAdapter
import com.fajri.strayver.util.Route
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun Navigation(navController: NavHostController, startDestination: String) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Route.ONBOARD) {
            OnBoardAdapter()
        }
        composable(Route.LOGIN) {
            LoginScreen()
        }
    }
}