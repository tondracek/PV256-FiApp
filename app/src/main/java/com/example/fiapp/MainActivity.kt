package com.example.fiapp

import android.annotation.SuppressLint
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
import com.example.fiapp.presentation.loginscreen.LoginScreen
import com.example.fiapp.presentation.loginscreen.LoginScreenViewmodel
import com.example.fiapp.presentation.navigation.Navigator
import com.example.fiapp.presentation.navigation.Screen
import com.example.fiapp.presentation.registrationscreen.RegistrationScreen
import com.example.fiapp.presentation.registrationscreen.RegistrationScreenViewModel
import com.example.fiapp.presentation.userhomescreen.UserHomeScreen
import com.example.fiapp.presentation.userhomescreen.UserHomeViewModel
import com.example.fiapp.ui.theme.FiAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FiAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    navigator.navController = navController

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
                                val viewModel: LoginScreenViewmodel = hiltViewModel()
                                val state by viewModel.state.collectAsState()

                                LoginScreen(
                                    state = state,
                                    onEvent = viewModel::onEvent,
                                )
                            }

                            composable(
                                route = Screen.UserAuth.Registration.route
                            ) {
                                val viewModel: RegistrationScreenViewModel = hiltViewModel()
                                val state by viewModel.state.collectAsState()

                                RegistrationScreen(
                                    state = state,
                                    onEvent = viewModel::onEvent,
                                )
                            }
                        }

                        composable(
                            route = Screen.UserHome.route
                        ) {
                            val viewModel: UserHomeViewModel = hiltViewModel()
                            val state by viewModel.state.collectAsState()

                            UserHomeScreen(
                                state = state,
                                onEvent = viewModel::onEvent,
                            )
                        }
                    }
                }
            }
        }
    }
}
