package com.example.mercurio.presentation.views.signin.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.mercurio.core.StringConstants.EMAIL
import com.example.mercurio.core.StringConstants.NAME
import com.example.mercurio.core.StringConstants.SIGN_UP
import com.example.mercurio.presentation.views.components.ButtonMercurio
import com.example.mercurio.presentation.views.components.PasswordTextFieldMercurio
import com.example.mercurio.presentation.views.components.TextFieldMercurio
import com.example.mercurio.presentation.views.signin.login.LoginState

@Composable
fun Signup(
    state: LoginState,
    onSignup: () -> Unit
) {
    TextFieldMercurio(
        value = state.name,
        onValueChange = { state.name = it },
        labelText = NAME,
        isError = state.nameError.isError,
        error = state.nameError.message,
        isThereNext = true,
        keyboardType = KeyboardType.Text
    )

    Spacer(modifier = Modifier.height(48.dp))
    TextFieldMercurio(
        value = state.email,
        onValueChange = { state.email = it },
        labelText = EMAIL,
        isError = state.emailError.isError,
        error = state.emailError.message,
        isThereNext = true,
        keyboardType = KeyboardType.Email
    )

    Spacer(modifier = Modifier.height(48.dp))
    PasswordTextFieldMercurio(
        value = state.password,
        onValueChange = { state.password = it },
        isError = state.passwordError.isError,
        error = state.passwordError.message,
    )

    Spacer(modifier = Modifier.height(48.dp))
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        ButtonMercurio(
            text = SIGN_UP,
            modifier = Modifier.fillMaxWidth(0.5f),
            onClick = {
                onSignup()
            }
        )
    }
}