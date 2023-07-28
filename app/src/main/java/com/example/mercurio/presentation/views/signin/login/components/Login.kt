package com.example.mercurio.presentation.views.signin.login.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mercurio.core.StringConstants.EMAIL
import com.example.mercurio.core.StringConstants.ENTER
import com.example.mercurio.core.StringConstants.FORGOT_PASSWORD
import com.example.mercurio.presentation.ui.theme.Beige
import com.example.mercurio.presentation.views.components.ButtonMercurio
import com.example.mercurio.presentation.views.components.PasswordTextFieldMercurio
import com.example.mercurio.presentation.views.components.TextFieldMercurio
import com.example.mercurio.presentation.views.signin.login.LoginState
import com.example.mercurio.presentation.views.signin.login.LoginViewModel

@Composable
fun Login(
    state: LoginState,
    viewModel: LoginViewModel,
    navController: NavController
) {
    TextFieldMercurio(
        value = state.email,
        onValueChange = { state.email = it },
        labelText = EMAIL,
        isError = state.isEmailError,
        error = state.emailError,
        isThereNext = true,
        keyboardType = KeyboardType.Email
    )

    Spacer(modifier = Modifier.height(36.dp))
    PasswordTextFieldMercurio(
        value = state.password,
        onValueChange = { state.password = it },
        isError = state.isPasswordError,
        error = state.passwordError,
    )

    Spacer(modifier = Modifier.height(4.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = FORGOT_PASSWORD,
            style = MaterialTheme.typography.bodySmall,
            color = Beige,
            modifier = Modifier.clickable {
                TODO("Password recovery")
            }
        )
    }

    Spacer(modifier = Modifier.height(36.dp))
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier.
        fillMaxWidth()
    ) {
        ButtonMercurio(
            text = ENTER,
            onClick = {
                TODO("Add functionality")
            }
        )
    }
}