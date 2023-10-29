package com.fajri.strayver.ui.presentation.onBoarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.model.OnBoardData
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.presentation.onBoarding.component.ChooseRole
import com.fajri.strayver.ui.theme.Neutral300
import com.fajri.strayver.ui.theme.Neutral800
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Type
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun OnBoardAdapter(
    viewModel: OnBoardViewModel= hiltViewModel(),
    navController: NavController
) {
    val screens = screenList
    val pagerState = rememberPagerState()
    val scope= rememberCoroutineScope()

    Column(
        Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HorizontalPager(count = screens.size, state = pagerState) { position ->
            OnBoardingScreen(screen = screens[position])
        }
        Spacer(modifier = Modifier.height(60.dp))
        HorizontalPagerIndicator(
            pagerState = pagerState,
            Modifier
                .align(Alignment.CenterHorizontally),
            indicatorHeight = 6.dp,
            indicatorWidth = 30.dp,
            activeColor = Primary700,
            inactiveColor = Neutral300,
            spacing = 6.dp
        )
        Spacer(modifier = Modifier.height(50.dp))
        AnimatedVisibility(visible = pagerState.currentPage == 3) {
            ChooseRole(viewModel, navController)
        }

        AnimatedVisibility(visible = pagerState.currentPage != (screens.size - 1)) {
            CustomButton(
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                },
                text = "Selanjutnya"
            )
        }
    }
}

@Composable
private fun OnBoardingScreen(screen: OnBoardData) {
    Column(
        Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AsyncImage(
            model = screen.image, contentDescription = "", modifier = Modifier.size
                (320.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = screen.title, style = Type.textLgSemiBold(), color = Primary900)
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = screen.description,
            style = Type.textSmRegular(),
            color = Neutral800,
            textAlign = TextAlign.Center
        )
    }
}