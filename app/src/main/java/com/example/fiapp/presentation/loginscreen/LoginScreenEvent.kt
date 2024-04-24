package com.example.fiapp.presentation.loginscreen

sealed interface LoginScreenEvent {

    data class ChangeEmail(val email: String) : LoginScreenEvent

    data class ChangePassword(val password: String) : LoginScreenEvent

    data object Login : LoginScreenEvent

    data object OpenRegistration : LoginScreenEvent
}