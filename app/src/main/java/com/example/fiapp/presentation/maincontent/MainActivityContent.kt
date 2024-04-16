package com.example.fiapp.presentation.maincontent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fiapp.domain.LoginResponse
import com.example.fiapp.domain.RegistrationResponse

@Composable
fun MainActivityContent(
    state: MainActivityContentState,
    onRegister: () -> Unit,
    onLogin: () -> Unit,
) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(onClick = { onRegister() }) {
            Text(text = "Register")
        }
        Button(onClick = { onLogin() }) {
            Text(text = "Login")
        }

        Column {
            Text(text = "register return value:", fontWeight = FontWeight.Bold)
            Text(text = "${state.registrationResponse}")
        }
        Column {
            Text(text = "login return value:", fontWeight = FontWeight.Bold)
            Text(text = "${state.loginResponse}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MainActivityContent(
        state = MainActivityContentState(
            loginResponse = LoginResponse.Success(42),
            registrationResponse = RegistrationResponse.Error("User already exists")
        ),
        onRegister = {},
        onLogin = {}
    )
}