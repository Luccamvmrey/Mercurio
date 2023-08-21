package com.example.mercurio.presentation.views.signin.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mercurio.core.delayNavigation
import com.example.mercurio.domain.models.Response
import com.example.mercurio.presentation.navigation.Screen
import com.example.mercurio.presentation.views.components.ContentHolder
import com.example.mercurio.presentation.views.signin.login.components.Login
import com.example.mercurio.presentation.views.signin.login.components.SigninSignupSwitcher
import com.example.mercurio.presentation.views.signin.login.components.Signup
import com.example.mercurio.presentation.views.signin.login.components.Switcher

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.collectAsState().value

    LaunchedEffect(
        key1 = state.getUserResponse
    ) {
        viewModel.getLoggedUser()
        val getUserResponse = state.getUserResponse

        if (getUserResponse is Response.Success) {
            val user = getUserResponse.data

            // TODO: Navigate to main screen with userId as parameter
        }
    }

    ContentHolder(
        verticalPadding = 154.dp,
        verticalArrangement = Arrangement.Top
    ) {
        SigninSignupSwitcher(
            switcher = state.switcher,
            onSwitch = {
                state.switcher = it
            }
        )

        Spacer(modifier = Modifier.height(48.dp))
        when (state.switcher) {
            Switcher.Signin -> {
                Login(
                    emailState = state.emailState,
                    passwordState = state.passwordState,
                    onRecoverPassword = {
                        delayNavigation {
                            navController.navigate(
                                Screen.RecoverPasswordScreen.route
                            )
                        }
                    },
                    onLogin = {
                        TODO("Add login functionality")
                    }
                )
            }
            Switcher.Signup -> {
                Signup(
                    nameState = state.nameState,
                    emailState = state.emailState,
                    passwordState = state.passwordState,
                    onSignup = {
                        TODO("Add functionality")
                    }
                )
            }
        }
    }
}