package com.fajri.strayver.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fajri.strayver.ui.presentation.login.LoginScreen
import com.fajri.strayver.ui.presentation.member.home.MemberHomeScreen
import com.fajri.strayver.ui.presentation.lupaSandi.LupaSandi
import com.fajri.strayver.ui.presentation.member.artikel_detail.ArtikelDetail
import com.fajri.strayver.ui.presentation.member.detail_donasi.DetailDonasiScreen
import com.fajri.strayver.ui.presentation.member.donasi.MemberDonasiScreen
import com.fajri.strayver.ui.presentation.member.edit_profil.EditProfilMemberScreen
import com.fajri.strayver.ui.presentation.onBoarding.OnBoardAdapter
import com.fajri.strayver.ui.presentation.register.RegisterScreen
import com.fajri.strayver.ui.presentation.member.kirim_donasi.KirimDonasiScreen
import com.fajri.strayver.ui.presentation.member.profil.MemberProfilScreen
import com.fajri.strayver.ui.presentation.member.riwayat.MemberRiwayatScreen
import com.fajri.strayver.ui.presentation.relawan.buatProyek.BuatProyekScreen
import com.fajri.strayver.ui.presentation.component.detailRiwayat.DetailRiwayatScreen
import com.fajri.strayver.ui.presentation.relawan.donasi.RelawanDonasiScreen
import com.fajri.strayver.ui.presentation.relawan.editProfil.RelawanEditProfilScreen
import com.fajri.strayver.ui.presentation.relawan.home.RelawanHomeScreen
import com.fajri.strayver.ui.presentation.relawan.profil.RelawanProfilScreen
import com.fajri.strayver.ui.presentation.relawan.riwayat.RelawanRiwayatScreen
import com.fajri.strayver.ui.presentation.relawan.tambahDonasi.TambahDonasiScreen
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
            MemberHomeScreen(navController = navController)
        }
        composable(Route.ARTIKEL_DETAIL) {
            ArtikelDetail(navController = navController)
        }
        composable(Route.MEMBER_DONASI) {
            MemberDonasiScreen(navController)
        }
        composable(
            Route.DETAIL_DONASI + "?donasiId={id}",
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.StringType
                }
            )
        ) {
            val donasiId = it.arguments?.getString("id")
            donasiId?.let {
                DetailDonasiScreen(navController, donasiId)
            }
        }
        composable(
            Route.KIRIM_DONASI + "?namaDonasi={namaDonasi}" + "?donasiId={id}" + "?type={type}" +
                    "?relawan={relawan}" + "?idRelawan={idRelawan}",
            arguments = listOf(
                navArgument(name = "namaDonasi") {
                    type = NavType.StringType
                },
                navArgument(name = "id") {
                    type = NavType.StringType
                },
                navArgument(name = "type") {
                    type = NavType.StringType
                },
                navArgument(name = "relawan") {
                    type = NavType.StringType
                },
                navArgument(name = "idRelawan") {
                    type = NavType.StringType
                }
            )
        ) {
            val namaDonasi = it.arguments?.getString("namaDonasi")
            val donasiId = it.arguments?.getString("id")
            val donasiType = it.arguments?.getString("type")
            val relawan = it.arguments?.getString("relawan")
            val idRelawan = it.arguments?.getString("idRelawan")
            KirimDonasiScreen(
                navController = navController, namaDonasi = namaDonasi!!, donasiId = donasiId!!,
                donasiType = donasiType!!, relawan = relawan!!, idRelawan = idRelawan!!
            )
        }
        composable(Route.MEMBER_RIWAYAT) {
            MemberRiwayatScreen(navController = navController)
        }
        composable(
            Route.DETAIL_RIWAYAT + "?transaksiId={transaksiId}",
            arguments = listOf(
                navArgument(name = "transaksiId") {
                    type= NavType.StringType
                }
            )
        ) {
            val transaksiId= it.arguments?.getString("transaksiId")
            DetailRiwayatScreen(navController, transaksiId!!)
        }
        composable(Route.MEMBER_PROFIL) {
            MemberProfilScreen(navController = navController)
        }
        composable(Route.MEMBER_EDIT_PROFIL) {
            EditProfilMemberScreen(navController)
        }
        composable(Route.RELAWAN_HOME) {
            RelawanHomeScreen(navController)
        }
        composable(
            Route.BUAT_PROYEK + "?type={type}",
            arguments = listOf(
                navArgument(name = "type") {
                    type = NavType.StringType
                }
            )
        ) {
            val tipeDonasi = it.arguments?.getString("type")
            tipeDonasi?.let {
                BuatProyekScreen(navController = navController, donasiType = tipeDonasi)
            }
        }
        composable(Route.RELAWAN_DONASI) {
            RelawanDonasiScreen(navController = navController)
        }
        composable(
            Route.TAMBAH_DONASI + "?donasiId={donasiId}",
            arguments = listOf(
                navArgument(name = "donasiId") {
                    type = NavType.StringType
                }
            )
        ) {
            val donasiId = it.arguments?.getString("donasiId")
            donasiId?.let {
                TambahDonasiScreen(navController = navController, donasiId = donasiId)
            }
        }
        composable(Route.RELAWAN_RIWAYAT) {
            RelawanRiwayatScreen(navController)
        }
        composable(Route.RELAWAN_PROFIL) {
            RelawanProfilScreen(navController = navController)
        }
        composable(Route.RELAWAN_EDIT_PROFIL) {
            RelawanEditProfilScreen(navController = navController)
        }
    }
}