package com.example.fiapp.domain.model

import parad0x.fi.proto.Login

// data classes

data class LoginRequest(
    val email: String = "",
    val password: String = "",
)

sealed interface LoginResponse {
    data class Success(val userId: Int) : LoginResponse
    data class Error(val message: String) : LoginResponse
}

// mapping functions

fun Login.UserId.toLoginResponse() = LoginResponse.Success(
    userId = this.userId
)

fun LoginRequest.toLoginCredentials(): Login.LoginCredentials =
    Login.LoginCredentials.newBuilder()
        .setEmail(email)
        .setPassword(password)
        .build()