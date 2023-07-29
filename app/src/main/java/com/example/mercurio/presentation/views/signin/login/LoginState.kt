package com.example.mercurio.presentation.views.signin.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.mercurio.core.StringConstants.NO_VALUE
import com.example.mercurio.domain.models.Response
import com.example.mercurio.domain.models.Response.Loading
import com.example.mercurio.domain.models.user.User
import com.example.mercurio.presentation.views.signin.login.components.Switcher

class LoginState {
    // Variables
    var name by mutableStateOf(NO_VALUE)
    var email by mutableStateOf(NO_VALUE)
    var password by mutableStateOf(NO_VALUE)

    // Booleans
    var isLogged by mutableStateOf(false)
    var isHandlingResponse by mutableStateOf(false)
    var isNameError by mutableStateOf(false)
    var isEmailError by mutableStateOf(false)
    var isPasswordError by mutableStateOf(false)

    // Errors
    var nameError by mutableStateOf(NO_VALUE)
    var emailError by mutableStateOf(NO_VALUE)
    var passwordError by mutableStateOf(NO_VALUE)

    // Responses
    var logUserResponse by mutableStateOf<Response<Boolean>>(Loading)
    var getUserResponse by mutableStateOf<Response<User>>(Loading)

    //
    var switcher by mutableStateOf(Switcher.Signin)
}


