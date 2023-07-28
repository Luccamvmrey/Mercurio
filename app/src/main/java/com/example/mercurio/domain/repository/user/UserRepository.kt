package com.example.mercurio.domain.repository.user

import com.example.mercurio.domain.models.Response
import com.example.mercurio.domain.models.user.User

interface UserRepository {
    suspend fun logUser(email: String, password: String): Response<Boolean>

    suspend fun createUser(name: String, email: String, password: String): Response<Boolean>

    suspend fun getLoggedUser(): Response<User>

    suspend fun sendPasswordRecoveryEmail(email: String): Response<Boolean>

    fun logout()
}