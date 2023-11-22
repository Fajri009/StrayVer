package com.fajri.strayver.ui.presentation.login.component

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.data.Resource
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.presentation.component.CustomCheckBox
import com.fajri.strayver.ui.presentation.component.CustomTextField
import com.fajri.strayver.ui.presentation.login.LoginViewModel
import com.fajri.strayver.ui.theme.Neutral900
import com.fajri.strayver.ui.theme.Primary800
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.ButtonType
import com.fajri.strayver.util.Route
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun Form(
    viewModel: LoginViewModel, navController: NavController, scope: CoroutineScope
) {


    val context = LocalContext.current
    val userRole = viewModel.userRole.collectAsState(initial = "")

    Text(
        text = "Email",
        style = Type.textSmMedium()
    )
    CustomTextField(
        text = viewModel.email.value,
        placeholder = "",
        onValueChange = {
            viewModel.onChangeEmail(it)
        }
    )
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = "Sandi",
        style = Type.textSmMedium()
    )
    CustomTextField(
        text = viewModel.sandi.value,
        placeholder = "",
        trailingIcon = Icons.Filled.Visibility,
        isPassword = true,
        showPassword = viewModel.showPassword.value,
        onPasswordToggle = {
            viewModel.showPassword(!viewModel.showPassword.value)
        },
        onValueChange = {
            viewModel.onChangePassword(it)
        }
    )
    Spacer(modifier = Modifier.height(15.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable {
                viewModel.onChecked()
            }
        ) {
            CustomCheckBox(
                onClick = {
                    viewModel.onChecked()
                },
                isClicked = viewModel.isChecked.value
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Ingat saya",
                style = Type.text2xsRegular(),
                color = Neutral900
            )
        }
        Text(
            modifier = Modifier
                .clickable {
                    navController.navigate(Route.LUPASANDI)
                },
            text = "Lupa Sandi?",
            style = Type.text2xsRegular(),
            color = Primary800,
        )

    }
    Spacer(modifier = Modifier.height(30.dp))

    CustomButton(
        text = "Login",
        onClick = {
            if (!viewModel.isNotValid()) {
                scope.launch {
                    viewModel.onSubmit().collect {
                        when (it) {
                            is Resource.Loading -> {
                                viewModel.setLoading(true)
                            }

                            is Resource.Success -> {
                                when (userRole.value) {
                                    "member" -> {
                                        navController.popBackStack()
                                        navController.navigate(Route.MEMBER_HOME)
                                    }

                                    "relawan" -> {
                                        navController.popBackStack()
                                        navController.navigate(Route.RELAWAN_HOME)
                                    }
                                }
                            }

                            is Resource.Error -> {
                                viewModel.setLoading(false)
                                Toast.makeText(
                                    context, it.message, Toast
                                        .LENGTH_SHORT
                                ).show()
                            }

                            else -> {}
                        }
                    }
                }
            } else {
                Toast.makeText(context, "Email dan sandi tidak boleh kosong", Toast.LENGTH_SHORT)
                    .show()
            }
        },
        type = ButtonType.LARGE
    )
}