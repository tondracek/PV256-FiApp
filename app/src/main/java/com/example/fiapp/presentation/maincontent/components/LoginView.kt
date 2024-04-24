package com.example.fiapp.presentation.maincontent.components

/**
 * This is a view
 * contains text areas for email and password
 * contains button for login
 */

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fiapp.presentation.maincontent.MainContentEvent
import com.example.fiapp.presentation.maincontent.MainContentState
import com.example.fiapp.ui.theme.FiAppTheme

@Composable
fun LoginView(
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
            value = state.password,
            onValueChange = { onEvent(MainContentEvent.ChangePassword(it)) },
            label = { Text("Password") }
        )
        HorizontalDivider()
        Button(onClick = { onEvent(MainContentEvent.Login) }) {
            Text(text = "Login")
        }
    }
}

@Preview
@Composable
fun LoginViewEmptyPreview() {
    FiAppTheme {
        LoginView(
            state = MainContentState(),
            onEvent = {}
        )
    }
}

@Preview
@Composable
fun LoginViewFilledPreview() {
    FiAppTheme {
        LoginView(
            state = MainContentState(
                email = "test_email",
                password = "test_password"
            ),
            onEvent = {}
        )
    }
}