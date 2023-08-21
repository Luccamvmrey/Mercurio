package com.example.mercurio.presentation.views.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldMercurio(
    value: String,
    onValueChange: (String) -> Unit,
    labelText: String,
    isError: Boolean = false,
    error: String,
    isThereNext: Boolean = false,
    isGo: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    val focusManager = LocalFocusManager.current

    val imeAction = if (isThereNext) {
        ImeAction.Next
    } else if (isGo){
        ImeAction.Go
    } else {
        ImeAction.Done
    }

    val keyboardActions = KeyboardActions(
        onNext = { focusManager.moveFocus(FocusDirection.Down) },
        onGo = { focusManager.clearFocus() },
        onDone = {  }
    )

    Column {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = MaterialTheme.typography.bodyMedium,
            label = {
                Text(
                    text = labelText,
                    style = MaterialTheme.typography.bodyMedium
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            singleLine = true,
            keyboardActions = keyboardActions,
            isError = isError
        )
        if (isError) {
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}