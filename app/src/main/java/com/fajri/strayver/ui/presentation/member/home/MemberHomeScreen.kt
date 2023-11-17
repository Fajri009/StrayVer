package com.fajri.strayver.ui.presentation.member.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.data.model.ArtikelModelResponse
import com.fajri.strayver.ui.presentation.member.home.component.ArtikelItemCard
import com.fajri.strayver.ui.presentation.member.home.component.Greet
import com.fajri.strayver.ui.presentation.member.home.component.ProyekTerbaru
import com.fajri.strayver.ui.presentation.member.home.component.SaldoCard
import com.fajri.strayver.ui.theme.Neutral100
import com.fajri.strayver.ui.theme.Neutral200
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Neutral500
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Type
import com.valentinilk.shimmer.shimmer

@Composable
fun MemberHomeScreen(
    viewModel: MemberHomeViewModel = hiltViewModel(),
    navController: NavController
) {

    val artikel by viewModel.artikel
    val artikelLoading by viewModel.artikelLoading

    LaunchedEffect(key1 = true) {
        viewModel.getArtikel()
    }

    LazyColumn(Modifier.padding(bottom = 56.dp)) {
        item {
            Box(Modifier.fillMaxWidth()) {
                Greet(
                    Modifier
                        .fillMaxWidth()
                        .height(178.dp)
                        .clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
                        .background(Primary700),
                    viewModel
                )
                SaldoCard(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .offset(y = 145.dp)
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(56.dp))
            ProyekTerbaru(navController = navController)
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)) {
                Text(text = "Artikel Terkini", style = Type.textMdSemiBold())
            }
        }
        ArtikelItem(artikelLoading, artikel)
    }
}

fun LazyListScope.ArtikelItem(isLoading: Boolean, artikelList: List<ArtikelModelResponse>) {

    if (isLoading) {
        items(3) {
            Card(
                modifier = Modifier
                    .height(140.dp)
                    .padding(horizontal = 20.dp),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Neutral50)
                        .shimmer()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Neutral200)
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    } else {
        items(artikelList) {
            ArtikelItemCard(artikel = it.item!!)
        }
    }
}