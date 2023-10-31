package com.fajri.strayver.ui.presentation.login

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.presentation.component.CustomCheckBox
import com.fajri.strayver.ui.presentation.component.CustomTextField
import com.fajri.strayver.ui.presentation.login.component.Form
import com.fajri.strayver.ui.presentation.login.component.Greeting
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Neutral700
import com.fajri.strayver.ui.theme.Neutral900
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Primary800
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.Route

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    Box(
        Modifier
            .fillMaxSize()
            .background(Primary700),
    ) {
        AsyncImage(model = R.drawable.ilustrasi, contentDescription = "")
        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 20.dp, top = 20.dp),
                text = "Login",
                color = Neutral50,
                style = Type.displayXsSemiBold(),
            )
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .background(
                        Neutral50,
                        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                    )
                    .fillMaxSize()
                    .padding(20.dp),
            ) {
                Column {
                    Greeting()

                    Spacer(modifier = Modifier.height(25.dp))

                    Form(viewModel, navController)

                    Spacer(modifier = Modifier.height(30.dp))

                    CustomButton(
                        onClick = {
                            viewModel.onSubmit(context)
                        },
                        text = "Login",
                        type = ButtonType.LARGE
                    )

                    Spacer(modifier = Modifier.height(30.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Tidak memiliki akun?",
                            style = Type.textXsRegular(),
                            color = Neutral900
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Daftar",
                            style = Type.textXsRegular(),
                            color = Primary800,
                            modifier = Modifier.clickable {
                                navController.navigate(Route.REGISTER)
                            }
                        )
                    }
                }
            }
        }
    }
}