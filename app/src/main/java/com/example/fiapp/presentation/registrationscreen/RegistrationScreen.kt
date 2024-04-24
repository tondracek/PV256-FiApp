package com.example.fiapp.presentation.registrationscreen

/**
 * This is a view
 * contains text areas for email, name, password and confirm password
 * contains button for register
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fiapp.presentation.Screen
import com.example.fiapp.presentation.components.PasswordField
import com.example.fiapp.ui.theme.FiAppTheme

@Composable
fun RegistrationScreen(
    state: RegistrationScreenState,
    onEvent: (RegistrationScreenEvent) -> Unit,
    navController: NavController,
) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = state.email,
            onValueChange = { onEvent(RegistrationScreenEvent.ChangeEmail(it)) },
            label = { Text("Email") }
        )
        TextField(
            value = state.name,
            onValueChange = { onEvent(RegistrationScreenEvent.ChangeName(it)) },
            label = { Text("Name") }
        )
        PasswordField(
            value = state.password,
            onValueChange = { onEvent(RegistrationScreenEvent.ChangePassword(it)) },
        )
        HorizontalDivider()
        Button(onClick = { onEvent(RegistrationScreenEvent.Register) }) {
            Text(text = "Register")
        }
        if (state.registrationResponse != null) {
            Text(text = "Registration response: ${state.registrationResponse}")
        }

        Text(
            text = "Already have an account? Click here!",
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .padding(top = 16.dp)
                .clickable { navController.navigate(Screen.UserAuth.Login.route) }
        )
    }
}

@Preview
@Composable
fun RegisterViewEmptyPreview() {
    FiAppTheme {
        RegistrationScreen(
            state = RegistrationScreenState(),
            onEvent = {},
            navController = rememberNavController()
        )
    }
}

@Preview
@Composable
fun RegisterViewFilledPreview() {
    FiAppTheme {
        RegistrationScreen(
            state = RegistrationScreenState(
                email = "test_email",
                name = "test_name",
                password = "test_password"
            ),
            onEvent = {},
            navController = rememberNavController()
        )
    }
}