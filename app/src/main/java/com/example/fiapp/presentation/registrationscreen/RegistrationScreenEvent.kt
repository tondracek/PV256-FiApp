package com.example.fiapp.presentation.registrationscreen

sealed interface RegistrationScreenEvent {

    data class ChangeName(val username: String) : RegistrationScreenEvent
    data class ChangeEmail(val email: String) : RegistrationScreenEvent
    data class ChangePassword(val password: String) : RegistrationScreenEvent

    data object Register : RegistrationScreenEvent
}