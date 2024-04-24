package com.example.fiapp.presentation.userhomescreen

sealed interface UserHomeScreenEvent {

    data object Logout : UserHomeScreenEvent

    data object NavigateToLogin : UserHomeScreenEvent
}
