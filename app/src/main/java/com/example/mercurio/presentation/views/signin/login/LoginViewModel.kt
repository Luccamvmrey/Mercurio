package com.example.mercurio.presentation.views.signin.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercurio.domain.use_cases.user.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userUseCases: UserUseCases
) : ViewModel() {
    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun getLoggedUser() = viewModelScope.launch {
        _state.value.getUserResponse = userUseCases.getLoggedUser()
    }
}