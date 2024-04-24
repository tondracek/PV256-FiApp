package com.example.fiapp.presentation.loginscreen

/**
 * This is a view
 * contains text areas for email and password
 * contains button for login
 */

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fiapp.presentation.Screen
import com.example.fiapp.presentation.components.PasswordField
import com.example.fiapp.ui.theme.FiAppTheme

@Composable
fun LoginScreen(
    state: LoginScreenState,
    onEvent: (LoginScreenEvent) -> Unit,
    navController: NavController,
) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = state.email,
            onValueChange = { onEvent(LoginScreenEvent.ChangeEmail(it)) },
            label = { Text("Email") }
        )
        PasswordField(
            value = state.password,
            onValueChange = { onEvent(LoginScreenEvent.ChangePassword(it)) },
        )
        HorizontalDivider()
        Button(onClick = { onEvent(LoginScreenEvent.Login) }) {
            Text(text = "Login")
        }
        if (state.loginResponse != null) {
            Text(text = "Login response: ${state.loginResponse}")
        }
        Text(
            text = "Don't have an account? Click here!",
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .padding(top = 16.dp)
                .clickable { navController.navigate(Screen.UserAuth.Registration.route) }
        )
    }
}

@Preview
@Composable
fun LoginViewEmptyPreview() {
    FiAppTheme {
        LoginScreen(
            state = LoginScreenState(),
            onEvent = {},
            navController = rememberNavController()
        )
    }
}

@Preview
@Composable
fun LoginViewFilledPreview() {
    FiAppTheme {
        LoginScreen(
            state = LoginScreenState(
                email = "test_email",
                password = "test_password"
            ),
            onEvent = {},
            navController = rememberNavController()
        )
    }
}