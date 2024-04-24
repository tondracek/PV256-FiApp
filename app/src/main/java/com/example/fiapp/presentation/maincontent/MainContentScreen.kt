package com.example.fiapp.presentation.maincontent

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.fiapp.domain.LoginResponse
import com.example.fiapp.domain.RegistrationResponse

@Composable
fun MainContentScreen(
    state: MainContentState,
    onEvent: (MainContentEvent) -> Unit,
) {

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