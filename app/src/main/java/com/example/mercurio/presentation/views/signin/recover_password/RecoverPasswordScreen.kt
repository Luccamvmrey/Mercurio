package com.example.mercurio.presentation.views.signin.recover_password

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mercurio.core.StringConstants.EMAIL
import com.example.mercurio.core.StringConstants.SEND
import com.example.mercurio.core.StringConstants.SEND_RECOVERY_EMAIL
import com.example.mercurio.presentation.views.components.ButtonMercurio
import com.example.mercurio.presentation.views.components.ContentHolder
import com.example.mercurio.presentation.views.components.TextFieldMercurio

@Composable
fun RecoverPasswordScreen(
    viewModel: RecoverPasswordViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.collectAsState().value

    ContentHolder {
        Text(
            text = SEND_RECOVERY_EMAIL,
            style = MaterialTheme.typography.bodySmall,
        )

        Spacer(modifier = Modifier.height(4.dp))
        TextFieldMercurio(
            value = state.email,
            onValueChange = { state.email = it },
            labelText = EMAIL,
            isError = state.emailError.isError,
            error = state.emailError.message
        )

        Spacer(modifier = Modifier.height(48.dp))
        ButtonMercurio(
            text = SEND,
            onClick = {
                TODO("Handle Response")
            }
        )
    }
}