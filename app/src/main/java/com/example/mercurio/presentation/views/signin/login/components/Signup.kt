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
import com.example.mercurio.domain.models.VariableState
import com.example.mercurio.presentation.views.components.ButtonMercurio
import com.example.mercurio.presentation.views.components.PasswordTextFieldMercurio
import com.example.mercurio.presentation.views.components.TextFieldMercurio

@Composable
fun Signup(
    nameState: VariableState<String>,
    emailState: VariableState<String>,
    passwordState: VariableState<String>,
    onSignup: () -> Unit
) {
    TextFieldMercurio(
        value = nameState.value,
        onValueChange = { nameState.onChange(it) },
        labelText = NAME,
        isError = nameState.error.isError,
        error = nameState.error.message,
        isThereNext = true,
        keyboardType = KeyboardType.Text
    )

    Spacer(modifier = Modifier.height(48.dp))
    TextFieldMercurio(
        value = emailState.value,
        onValueChange = { emailState.onChange(it) },
        labelText = EMAIL,
        isError = emailState.error.isError,
        error = emailState.error.message,
        isThereNext = true,
        keyboardType = KeyboardType.Email
    )

    Spacer(modifier = Modifier.height(48.dp))
    PasswordTextFieldMercurio(
        value = passwordState.value,
        onValueChange = { passwordState.onChange(it) },
        isError = passwordState.error.isError,
        error = passwordState.error.message,
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