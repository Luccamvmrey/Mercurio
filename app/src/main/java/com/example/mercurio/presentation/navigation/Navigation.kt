package com.example.mercurio.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mercurio.presentation.views.signin.login.LoginScreen
import com.example.mercurio.presentation.views.signin.recover_password.RecoverPasswordScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.RecoverPasswordScreen.route) {
            RecoverPasswordScreen(navController = navController)
        }
    }
}