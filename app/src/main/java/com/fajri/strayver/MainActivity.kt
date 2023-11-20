package com.fajri.strayver

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fajri.strayver.navigation.Navigation
import com.fajri.strayver.ui.presentation.component.CustomScaffold
import com.fajri.strayver.util.Route
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@OptIn(ExperimentalPagerApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val memberScreen = listOf(
        Route.MEMBER_HOME,
        Route.MEMBER_DONASI,
        Route.MEMBER_RIWAYAT,
        Route.MEMBER_PROFIL,
        Route.MEMBER_EDIT_PROFIL,
    )

    val relawanScreen = listOf(
        Route.RELAWAN_HOME,
        Route.RELAWAN_DONASI,
        Route.RELAWAN_RIWAYAT,
        Route.RELAWAN_PROFIL,
        Route.RELAWAN_EDIT_PROFIL
    )

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val navController = rememberNavController()
            val backStackEntry by navController.currentBackStackEntryAsState()
            val currPage = backStackEntry?.destination?.route
            val userRole= viewModel.userRole.collectAsStateWithLifecycle(initialValue = "")

            Surface(
                modifier = Modifier.windowInsetsPadding(WindowInsets(bottom = 40.dp))
            ) {
                CustomScaffold(
                    navController = navController,
                    showBottomBar =
                    if (userRole.value == "member") {
                        currPage in memberScreen
                    } else {
                        currPage in relawanScreen
                    }
                ) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}