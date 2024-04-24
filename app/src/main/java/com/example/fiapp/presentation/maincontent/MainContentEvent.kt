package com.example.fiapp.presentation.maincontent

sealed interface MainContentEvent {

    data class ChangeName(val username: String) : MainContentEvent
    data class ChangeEmail(val email: String) : MainContentEvent
    data class ChangePassword(val password: String) : MainContentEvent

    data object Login : MainContentEvent
    data object Register : MainContentEvent

    data object Switch : MainContentEvent
}