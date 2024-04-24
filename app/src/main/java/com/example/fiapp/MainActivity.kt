package com.example.fiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.fiapp.presentation.Screen
import com.example.fiapp.presentation.loginscreen.LoginScreen
import com.example.fiapp.presentation.loginscreen.LoginScreenViewmodel
import com.example.fiapp.presentation.registrationscreen.RegistrationScreen
import com.example.fiapp.presentation.registrationscreen.RegistrationScreenViewModel
import com.example.fiapp.ui.theme.FiAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FiAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.UserAuth.route
                    ) {

                        navigation(
                            route = Screen.UserAuth.route,
                            startDestination = Screen.UserAuth.Login.route
                        ) {
                            composable(
                                route = Screen.UserAuth.Login.route
                            ) {
                                val viewModel = hiltViewModel<LoginScreenViewmodel>()
                                val state by viewModel.state.collectAsState()

                                LoginScreen(
                                    state = state,
                                    onEvent = viewModel::onEvent,
                                    navController = navController
                                )
                            }

                            composable(
                                route = Screen.UserAuth.Registration.route
                            ) {
                                val viewModel = hiltViewModel<RegistrationScreenViewModel>()
                                val state by viewModel.state.collectAsState()

                                RegistrationScreen(
                                    state = state,
                                    onEvent = viewModel::onEvent,
                                    navController = navController
                                )
                            }
                        }

                        composable(
                            route = Screen.UserHome.route
                        ) {

                        }
                    }
                }
            }
        }
    }
}
