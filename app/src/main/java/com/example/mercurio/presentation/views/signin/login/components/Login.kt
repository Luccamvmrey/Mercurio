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
import com.example.mercurio.core.StringConstants.EMAIL
import com.example.mercurio.core.StringConstants.ENTER
import com.example.mercurio.core.StringConstants.FORGOT_PASSWORD
import com.example.mercurio.presentation.ui.theme.Beige
import com.example.mercurio.presentation.views.components.ButtonMercurio
import com.example.mercurio.presentation.views.components.PasswordTextFieldMercurio
import com.example.mercurio.presentation.views.components.TextFieldMercurio
import com.example.mercurio.presentation.views.signin.login.LoginState

@Composable
fun Login(
    state: LoginState,
    onRecoverPassword: () -> Unit,
    onLogin: () -> Unit,
) {
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
                onRecoverPassword()
            }
        )
    }

    Spacer(modifier = Modifier.height(48.dp))
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        ButtonMercurio(
            text = ENTER,
            modifier = Modifier.fillMaxWidth(0.5f),
            onClick = {
                onLogin()
            }
        )
    }
}