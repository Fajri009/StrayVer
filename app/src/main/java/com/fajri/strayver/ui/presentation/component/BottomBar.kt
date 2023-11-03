package com.fajri.strayver.ui.presentation.component

import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.R
import com.fajri.strayver.model.BottomBarData
import com.fajri.strayver.ui.theme.Neutral300
import com.fajri.strayver.ui.theme.Neutral600
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.Route

@Composable
fun BottomBar(navController: NavController) {

    val bottomBarList = listOf(
        BottomBarData(
            icon = painterResource(id = R.drawable.home),
            title = "Beranda",
            relawanRoute = Route.RELAWAN_HOME,
            memberRoute = Route.MEMBER_HOME
        ),
        BottomBarData(
            icon = painterResource(id = R.drawable.donasi),
            title = "Donasi",
            relawanRoute = Route.RELAWAN_DONASI,
            memberRoute = Route.MEMBER_DONASI
        ),
        BottomBarData(
            icon = painterResource(id = R.drawable.riwayat),
            title = "Riwayat",
            relawanRoute = Route.RELAWAN_RIWAYAT,
            memberRoute = Route.MEMBER_RIWAYAT
        ),
        BottomBarData(
            icon = painterResource(id = R.drawable.profil),
            title = "Profil",
            relawanRoute = Route.RELAWAN_PROFIL,
            memberRoute = Route.MEMBER_PROFIL
        ),
    )

    val currPage = navController.currentBackStackEntry?.destination?.route

    BottomAppBar(backgroundColor = Color.White, elevation = 6.dp) {
        bottomBarList.forEach {
            BottomNavigationItem(
                selected = false,
                onClick = {
                    if (currPage!!.contains("Member")) {
                        navController.navigate(it.memberRoute)
                    } else if (currPage.contains("Relawan")) {
                        navController.navigate(it.relawanRoute)
                    }
                },
                icon = {
                    Icon(
                        painter = it.icon,
                        contentDescription = it.title,
                        tint =
                        if (currPage!!.contains("Member")) {
                            if (currPage == it.memberRoute) {
                                Primary700
                            } else {
                                Neutral300
                            }
                        } else if (currPage.contains("Relawan")) {
                            if (currPage == it.relawanRoute) {
                                Primary700
                            } else {
                                Neutral300
                            }
                        } else {
                            Color.Black
                        }
                    )
                },
                label = {
                    Text(
                        text = it.title,
                        style = Type.text2xsRegular(),
                        color =
                        if (currPage!!.contains("Member")) {
                            if (currPage == it.memberRoute) {
                                Primary700
                            } else {
                                Neutral300
                            }
                        } else if (currPage.contains("Relawan")) {
                            if (currPage == it.relawanRoute) {
                                Primary700
                            } else {
                                Neutral300
                            }
                        } else {
                            Color.Black
                        }
                    )
                }
            )
        }
    }
}