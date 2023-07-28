package com.example.mercurio.presentation.views.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.mercurio.presentation.ui.theme.Beige
import com.example.mercurio.presentation.ui.theme.DeepBlue

@Composable
fun ButtonMercurio(
    text: String,
    backgroundColor: Color = Beige,
    contentColor: Color = DeepBlue,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}