package com.example.fiapp.presentation.userhomescreen

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fiapp.domain.model.User
import com.example.fiapp.domain.model.UserId
import com.example.fiapp.presentation.components.LoadingScreen


@Composable
fun UserHomeScreen(
    state: UserHomeScreenState,
    onEvent: (UserHomeScreenEvent) -> Unit,
) {
    AnimatedContent(
        targetState = state,
        label = ""
    ) { actualState ->
        Box(modifier = Modifier.fillMaxSize()) {
            when (actualState) {
                UserHomeScreenState.Loading -> LoadingScreen()
                UserHomeScreenState.NotLoggedIn -> NotLoggedInScreen(onEvent)
                is UserHomeScreenState.Success -> SuccessScreen(actualState, onEvent)
            }
        }
    }
}

@Composable
fun SuccessScreen(
    state: UserHomeScreenState.Success,
    onEvent: (UserHomeScreenEvent) -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "User icon",
            modifier = Modifier
                .padding(16.dp)
                .size(128.dp)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "Welcome, user ${state.user.id.value}")
            Button(
                onClick = { onEvent(UserHomeScreenEvent.Logout) }
            ) {
                Text(text = "Logout")
            }
        }
    }
}

@Composable
fun NotLoggedInScreen(
    onEvent: (UserHomeScreenEvent) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "You are not logged in",
            style = MaterialTheme.typography.titleLarge
        )
        Button(onClick = {
            onEvent(UserHomeScreenEvent.NavigateToLogin)
        }) {
            Text(text = "Log in")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    UserHomeScreen(
        state = UserHomeScreenState.Loading,
        onEvent = {}
    )
}

@Preview(showBackground = true)
@Composable
fun UserHomeScreenPreview() {
    UserHomeScreen(
        state = UserHomeScreenState.NotLoggedIn,
        onEvent = {}
    )
}

@Preview(showBackground = true)
@Composable
fun SuccessScreenPreview() {
    UserHomeScreen(
        state = UserHomeScreenState.Success(
            user = User(id = UserId(1))
        ),
        onEvent = {}
    )
}
