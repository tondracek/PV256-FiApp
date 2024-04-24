package com.example.fiapp.presentation.navigation

sealed class Screen(val route: String) {
    data object UserAuth : Screen("user_auth") {
        data object Login : Screen("login")

        data object Registration : Screen("registration")
    }

    data object UserHome : Screen("user_home")
}