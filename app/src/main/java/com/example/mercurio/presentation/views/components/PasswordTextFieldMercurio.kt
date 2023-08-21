package com.example.mercurio.presentation.views.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.mercurio.core.StringConstants.PASSWORD

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextFieldMercurio(
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean = false,
    error: String
) {
   var passwordVisibility by remember {
       mutableStateOf(false)
   }

   val focusManager = LocalFocusManager.current

   val icon = if (passwordVisibility) {
       Icons.Rounded.VisibilityOff
   } else {
       Icons.Rounded.Visibility
   }

    val keyboardActions = KeyboardActions(
        onGo = { focusManager.clearFocus() }
    )

    Column {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = MaterialTheme.typography.bodyMedium,
            label = {
                Text(
                    text = PASSWORD,
                    style = MaterialTheme.typography.bodyMedium
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Go
            ),
            keyboardActions = keyboardActions,
            isError = isError,
            trailingIcon = {
                IconButton(
                    onClick = {
                        passwordVisibility = !passwordVisibility
                    }
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Visibility icon",
                    )
                }
            },
            visualTransformation =
                if (passwordVisibility) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                }
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