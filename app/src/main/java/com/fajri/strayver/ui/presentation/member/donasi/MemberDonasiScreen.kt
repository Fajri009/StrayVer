package com.fajri.strayver.ui.presentation.member.donasi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.component.CustomTextField
import com.fajri.strayver.ui.presentation.component.LoadingDialog
import com.fajri.strayver.ui.presentation.member.donasi.component.DonasiCard
import com.fajri.strayver.ui.presentation.member.donasi.component.DonasiContent
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Type

@Composable
fun MemberDonasiScreen(
    navController: NavController,
    viewModel: MemberDonasiViewModel = hiltViewModel()
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary700)
    ) {
        AsyncImage(
            model = R.drawable.ilustrasi,
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )
        Column(Modifier.align(Alignment.TopStart)) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Donasi",
                style = Type.displayXsSemiBold(),
                color = Neutral50,
                modifier = Modifier.padding(top = 20.dp, start = 20.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextField(
                text = viewModel.search.value,
                placeholder = "Search",
                trailingIcon = Icons.Default.Search,
                onValueChange = {
                    viewModel.onChangeSearch(it)
                },
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(28.dp))
            DonasiContent(navController = navController, viewModel)
        }
    }
}