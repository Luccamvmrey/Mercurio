package com.example.mercurio.domain.use_cases.user.use_cases

import com.example.mercurio.domain.repository.user.UserRepository

class CreateUser(
    private val repo: UserRepository
) {
    suspend operator fun invoke(
        name: String,
        email: String,
        password: String
    ) = repo.createUser(name, email, password)
}