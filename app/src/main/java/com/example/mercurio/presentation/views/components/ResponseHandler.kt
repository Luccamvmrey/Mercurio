package com.example.mercurio.presentation.views.components

import androidx.compose.runtime.Composable
import com.example.mercurio.domain.models.Response
import com.example.mercurio.domain.models.Response.Failure
import com.example.mercurio.domain.models.Response.Loading
import com.example.mercurio.domain.models.Response.Success

@Composable
fun ResponseHandler(
    response: Response<Any>,
    onSuccess: () -> Unit,
    onFailure: () -> Unit = {}
) {
    when (response) {
        Loading -> {
            ProgressBarMercurio()
        }
        is Success -> {
            onSuccess()
        }
        is Failure -> {
            onFailure()
        }
    }
}

@Composable
fun ResponseHandler(
    response: Response<Any>,
    takesComposable: Boolean = true,
    onSuccess: @Composable () -> Unit,
    onFailure: () -> Unit = {}
) {
    when (response) {
        Loading -> {
            ProgressBarMercurio()
        }
        is Success -> {
            onSuccess()
        }
        is Failure -> {
            onFailure()
        }
    }
}