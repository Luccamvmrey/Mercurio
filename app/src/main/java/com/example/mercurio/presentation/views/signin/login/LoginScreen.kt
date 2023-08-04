package com.example.mercurio.presentation.views.signin.login

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mercurio.core.delayNavigation
import com.example.mercurio.presentation.navigation.Screen
import com.example.mercurio.presentation.views.signin.login.components.Content
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

    Content(
        state = state,
        viewModel = viewModel,
        navController = navController
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
                    state = state,
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
                    state = state,
                    onSignup = {
                        TODO("Add functionality")
                    }
                )
            }
        }
    }
}