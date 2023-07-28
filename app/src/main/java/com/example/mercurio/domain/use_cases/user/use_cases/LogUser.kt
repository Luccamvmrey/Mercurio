package com.example.mercurio.domain.use_cases.user.use_cases

import com.example.mercurio.domain.repository.user.UserRepository

class LogUser(
    private val repo: UserRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ) = repo.logUser(email, password)
}