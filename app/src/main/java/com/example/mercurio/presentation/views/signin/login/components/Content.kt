package com.example.mercurio.presentation.views.signin.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mercurio.domain.models.Response.Success
import com.example.mercurio.presentation.ui.theme.DeepBlue
import com.example.mercurio.presentation.views.signin.login.LoginState
import com.example.mercurio.presentation.views.signin.login.LoginViewModel

@Composable
fun Content(
    state: LoginState,
    viewModel: LoginViewModel,
    navController: NavController,
    content: @Composable () -> Unit
) {
    val focusManager = LocalFocusManager.current
    val interactionSource = remember {
        MutableInteractionSource()
    }

    LaunchedEffect(key1 = state.getUserResponse) {
        viewModel.getLoggedUser()
        val getUserResponse = state.getUserResponse

        if (getUserResponse is Success) {
            val user = getUserResponse.data

            TODO("Navigate to MainScreen with userId as parameter.")
        }
    }

    if (!state.isLogged) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .background(DeepBlue)
                .clickable(
                    indication = null,
                    interactionSource = interactionSource
                ) {
                    focusManager.clearFocus()
                }
                .padding(horizontal = 64.dp, vertical = 154.dp)
        ) {
            content()
        }
    }
}