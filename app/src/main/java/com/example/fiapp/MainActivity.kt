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
import com.example.fiapp.presentation.maincontent.MainActivityContent
import com.example.fiapp.presentation.maincontent.MainActivityViewModel
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
                    val viewModel = hiltViewModel<MainActivityViewModel>()
                    val state by viewModel.state.collectAsState()

                    MainActivityContent(
                        state = state,
                        onRegister = viewModel::register,
                        onLogin = viewModel::login
                    )
                }
            }
        }
    }
}
