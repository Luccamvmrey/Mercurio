package com.example.mercurio.presentation.views.signin.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.mercurio.core.StringConstants.NO_VALUE
import com.example.mercurio.domain.models.Response
import com.example.mercurio.domain.models.Response.Loading
import com.example.mercurio.domain.models.user.User
import com.example.mercurio.domain.models.Error
import com.example.mercurio.domain.models.VariableState
import com.example.mercurio.presentation.views.signin.login.components.Switcher


class LoginState {
    // Variables
    var nameState by mutableStateOf(
        VariableState(
        value = NO_VALUE,
        error = Error()
        )
    )
    var emailState by mutableStateOf(
        VariableState(
            value = NO_VALUE,
            error = Error()
        )
    )
    var passwordState by mutableStateOf(
        VariableState(
            value = NO_VALUE,
            error = Error()
        )
    )

    // Booleans
    var isHandlingResponse by mutableStateOf(false)

    // Responses
    var logUserResponse by mutableStateOf<Response<Boolean>>(Loading)
    var getUserResponse by mutableStateOf<Response<User>>(Loading)

    //
    var switcher by mutableStateOf(Switcher.Signin)
}


