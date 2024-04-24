package com.example.fiapp.presentation.maincontent.components

/**
 * This is a view
 * contains text areas for email, name, password and confirm password
 * contains button for register
 */

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fiapp.presentation.maincontent.MainContentEvent
import com.example.fiapp.presentation.maincontent.MainContentState
import com.example.fiapp.ui.theme.FiAppTheme

@Composable
fun RegistrationView(
    state: MainContentState,
    onEvent: (MainContentEvent) -> Unit,
) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = state.email,
            onValueChange = { onEvent(MainContentEvent.ChangeEmail(it)) },
            label = { Text("Email") }
        )
        TextField(
            value = state.name,
            onValueChange = { onEvent(MainContentEvent.ChangeName(it)) },
            label = { Text("Name") }
        )
        PasswordField(
            value = state.password,
            onValueChange = { onEvent(MainContentEvent.ChangePassword(it)) },
        )
        HorizontalDivider()
        Button(onClick = { onEvent(MainContentEvent.Register) }) {
            Text(text = "Register")
        }
        if (state.registrationResponse != null) {
            Text(text = "Registration response: ${state.registrationResponse}")
        }
    }
}

@Preview
@Composable
fun RegisterViewEmptyPreview() {
    FiAppTheme {
        RegistrationView(
            state = MainContentState(),
            onEvent = {}
        )
    }
}

@Preview
@Composable
fun RegisterViewFilledPreview() {
    FiAppTheme {
        RegistrationView(
            state = MainContentState(
                email = "test_email",
                name = "test_name",
                password = "test_password"
            ),
            onEvent = {}
        )
    }
}