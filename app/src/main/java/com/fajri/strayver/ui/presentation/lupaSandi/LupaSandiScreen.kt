package com.fajri.strayver.ui.presentation.lupaSandi

import android.widget.Toast
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
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.data.Resource
import com.fajri.strayver.ui.presentation.component.LoadingDialog
import com.fajri.strayver.ui.presentation.lupaSandi.component.LupaSandiForm
import com.fajri.strayver.ui.presentation.lupaSandi.component.LupaSandiHead
import com.fajri.strayver.ui.presentation.lupaSandi.component.Popup
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.Route
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun LupaSandi(
    navController: NavController,
    viewModel: LupaSandiViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val scope= rememberCoroutineScope()

    if (viewModel.isShowDialog.value) {
        Popup(navController = navController)
    }

    if (viewModel.isLoading.value) {
        LoadingDialog()
    }

    Box(
        Modifier
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
            LupaSandiHead(navController = navController)
            LupaSandiForm(viewModel, context, scope)
        }
    }
}