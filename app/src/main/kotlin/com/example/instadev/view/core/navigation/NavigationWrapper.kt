package com.example.instadev.view.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.instadev.view.auth.login.LoginScreen
import com.example.instadev.view.auth.register.RegisterScreen

@Composable
fun NavigationWrapper() {

    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = Login) {

        composable<Login> {

            LoginScreen(navigateToRegister = { navController.navigate(route = Register) })
        }

        composable<Register> {

            RegisterScreen(navigateBack = { navController.popBackStack() })
        }
    }
}