package com.example.mercurio.presentation.navigation

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")

    fun withArgs(vararg parameters: String): String {
        return buildString {
            append(route)
            parameters.forEach { param ->
                append("/$param")
            }
        }
    }
}
