package com.example.mercurio.presentation.views.signin.recover_password

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.mercurio.core.StringConstants.NO_VALUE
import com.example.mercurio.domain.models.Response
import com.example.mercurio.presentation.views.components.Error

class RecoverPasswordState {
    // Variables
    var email by mutableStateOf(NO_VALUE)

    // Booleans
    var isHandlingResponse by mutableStateOf(false)

    // Errors
    var emailError by mutableStateOf(Error())

    // Responses
    var sendEmailResponse by mutableStateOf<Response<Boolean>>(Response.Loading)
}