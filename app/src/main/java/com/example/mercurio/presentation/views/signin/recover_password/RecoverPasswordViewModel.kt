package com.example.mercurio.presentation.views.signin.recover_password

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercurio.domain.use_cases.user.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecoverPasswordViewModel @Inject constructor(
    private val userUseCases: UserUseCases
) : ViewModel() {
    private val _state = MutableStateFlow(RecoverPasswordState())
    val state = _state.asStateFlow()

    fun sendPasswordRecoveryEmail(email: String) = viewModelScope.launch {
        _state.value.sendEmailResponse = userUseCases.sendPasswordRecoveryEmail(email)
    }
}