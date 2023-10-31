package com.fajri.strayver.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fajri.strayver.ui.presentation.login.LoginScreen
import com.fajri.strayver.ui.presentation.member.home.MemberHomeScreen
import com.fajri.strayver.ui.presentation.lupaSandi.LupaSandi
import com.fajri.strayver.ui.presentation.onBoarding.OnBoardAdapter
import com.fajri.strayver.ui.presentation.register.RegisterScreen
import com.fajri.strayver.ui.presentation.member.home.MemberHomeScreen
import com.fajri.strayver.ui.presentation.splash.SplashScreen
import com.fajri.strayver.util.Route
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Route.SPLASH) {
        composable(Route.SPLASH) {
            SplashScreen(navController = navController)
        }

        composable(Route.ONBOARD) {
            OnBoardAdapter(navController = navController)
        }
        composable(Route.REGISTER) {
            RegisterScreen(navController)
        }
        composable(Route.LOGIN) {
            LoginScreen(navController = navController)
        }
        composable(Route.LUPASANDI) {
            LupaSandi(navController)
        }
        composable(Route.MEMBER_HOME) {
            MemberHomeScreen()
        }
    }
}