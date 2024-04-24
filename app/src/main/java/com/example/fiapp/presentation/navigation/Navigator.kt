package com.example.fiapp.presentation.navigation

import androidx.navigation.NavHostController

class Navigator {

    var navController: NavHostController? = null

    fun navigateTo(screen: Screen) {
        navController?.navigate(screen.route)
    }

    fun navigateBack() {
        navController?.popBackStack()
    }
}
