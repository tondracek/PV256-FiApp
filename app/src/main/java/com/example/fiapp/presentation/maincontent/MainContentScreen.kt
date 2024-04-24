package com.example.fiapp.presentation.maincontent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fiapp.domain.LoginResponse
import com.example.fiapp.domain.RegistrationResponse
import com.example.fiapp.presentation.maincontent.components.LoginView
import com.example.fiapp.presentation.maincontent.components.RegistrationView

@Composable
fun MainContentScreen(
    state: MainContentState,
    onEvent: (MainContentEvent) -> Unit,
) {

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center
        )
        LoginView(
            state = state,
            onEvent = onEvent
        )
        HorizontalDivider()
        Text(
            text = "Registration",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center
        )
        RegistrationView(
            state = state,
            onEvent = onEvent
        )
    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MainContentScreen(
        state = MainContentState(
            loginResponse = LoginResponse.Success(42),
            registrationResponse = RegistrationResponse.Error("User already exists")
        ),
        onEvent = {}
    )
}