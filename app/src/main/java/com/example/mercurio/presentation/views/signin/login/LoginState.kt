package com.example.mercurio.presentation.views.signin.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.mercurio.core.StringConstants.NO_VALUE
import com.example.mercurio.domain.models.Response
import com.example.mercurio.domain.models.Response.Loading
import com.example.mercurio.domain.models.user.User
import com.example.mercurio.domain.models.Error
import com.example.mercurio.presentation.views.signin.login.components.Switcher

class LoginState {
    // Variables
    var name by mutableStateOf(NO_VALUE)
    var email by mutableStateOf(NO_VALUE)
    var password by mutableStateOf(NO_VALUE)

    // Booleans
    var isHandlingResponse by mutableStateOf(false)

    // Errors
    var nameError by mutableStateOf(Error())
    var emailError by mutableStateOf(Error())
    var passwordError by mutableStateOf(Error())

    // Responses
    var logUserResponse by mutableStateOf<Response<Boolean>>(Loading)
    var getUserResponse by mutableStateOf<Response<User>>(Loading)

    //
    var switcher by mutableStateOf(Switcher.Signin)
}


