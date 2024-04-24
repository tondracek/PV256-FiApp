package com.example.fiapp.presentation.userhomescreen

import com.example.fiapp.domain.model.User

sealed interface UserHomeScreenState {

    data object NotLoggedIn : UserHomeScreenState

    data object Loading : UserHomeScreenState

    data class Success(val user: User) : UserHomeScreenState
}