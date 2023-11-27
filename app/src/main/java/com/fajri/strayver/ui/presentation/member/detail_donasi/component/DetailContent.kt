package com.fajri.strayver.ui.presentation.member.detail_donasi.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.model.Donasi
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.presentation.member.detail_donasi.DetaiDonasiViewModel
import com.fajri.strayver.ui.theme.Pink40
import com.fajri.strayver.ui.theme.Primary400
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.util.ButtonType
import com.fajri.strayver.util.Route

@Composable
fun DetailContent(navController: NavController, donasi: Donasi) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 40.dp)
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Shades50)
            .padding(20.dp),
    ) {
        ContentHead(
            donasi,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Divider(
            Modifier
                .fillMaxWidth()
                .height(1.dp), color = Primary400
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)

        ) {
            item {
                Spacer(modifier = Modifier.height(20.dp))
                ContentDescription(donasi)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            CustomButton(
                onClick = {
                    navController.navigate(
                        Route.KIRIM_DONASI + "?namaDonasi=${donasi.title}" +
                                "?donasiId=${donasi.donasiId}" +
                                "?type=${donasi.category}" + "?relawan=${donasi.relawanNama}"
                    )
                },
                text = "Donasi",
                type = ButtonType.LARGE,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}
