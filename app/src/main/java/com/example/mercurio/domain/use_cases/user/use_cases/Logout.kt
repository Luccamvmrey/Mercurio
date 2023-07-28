package com.example.mercurio.domain.use_cases.user.use_cases

import com.example.mercurio.domain.repository.user.UserRepository

class Logout(
    private val repo: UserRepository
) {
    operator fun invoke() = repo.logout()
}