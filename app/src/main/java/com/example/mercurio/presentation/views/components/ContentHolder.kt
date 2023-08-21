package com.example.mercurio.presentation.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.Dp
import com.example.mercurio.presentation.ui.theme.spacing

@Composable
fun ContentHolder(
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    verticalArrangement: Arrangement.Vertical = Arrangement.Center,
    padding: Dp = MaterialTheme.spacing.extraLarge,
    content: @Composable () -> Unit
) {
    val focusManager = LocalFocusManager.current
    val interactionSource = remember {
        MutableInteractionSource()
    }


    Column(
        horizontalAlignment = horizontalAlignment,
        verticalArrangement = verticalArrangement,
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                indication = null,
                interactionSource = interactionSource
            ) {
                focusManager.clearFocus()
            }
            .padding(padding)
    ) {
        content()
    }
}

@Composable
fun ContentHolder(
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    verticalArrangement: Arrangement.Vertical = Arrangement.Center,
    verticalPadding: Dp = MaterialTheme.spacing.extraLarge,
    horizontalPadding: Dp = MaterialTheme.spacing.extraLarge,
    content: @Composable () -> Unit
) {
    val focusManager = LocalFocusManager.current
    val interactionSource = remember {
        MutableInteractionSource()
    }


    Column(
        horizontalAlignment = horizontalAlignment,
        verticalArrangement = verticalArrangement,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .clickable(
                indication = null,
                interactionSource = interactionSource
            ) {
                focusManager.clearFocus()
            }
            .padding(vertical = verticalPadding, horizontal = horizontalPadding)
    ) {
        content()
    }
}

