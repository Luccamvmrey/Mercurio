package com.example.mercurio.domain.use_cases.user.use_cases

import com.example.mercurio.domain.repository.user.UserRepository

class GetLoggedUser(
    private val repo: UserRepository
) {
    suspend operator fun invoke() = repo.getLoggedUser()
}