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
import com.example.mercurio.domain.models.VariableState
import com.example.mercurio.presentation.views.components.ButtonMercurio
import com.example.mercurio.presentation.views.components.PasswordTextFieldMercurio
import com.example.mercurio.presentation.views.components.TextFieldMercurio

@Composable
fun Login(
    emailState: VariableState<String>,
    passwordState: VariableState<String>,
    onRecoverPassword: () -> Unit,
    onLogin: () -> Unit,
) {
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
        onValueChange = { emailState.onChange(it) },
        isError = passwordState.error.isError,
        error = passwordState.error.message,
    )

    Spacer(modifier = Modifier.height(4.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = FORGOT_PASSWORD,
            style = MaterialTheme.typography.bodySmall,
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