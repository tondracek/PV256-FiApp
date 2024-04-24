package com.example.fiapp.domain.model

import parad0x.fi.proto.Login

// data classes

data class RegistrationRequest(
    val email: String,
    val name: String,
    val password: String,
)

sealed interface RegistrationResponse {
    data class Success(val userId: Int) : RegistrationResponse
    data class Error(val message: String) : RegistrationResponse
}

// mapping functions

fun Login.UserId.toRegistrationResponse() = RegistrationResponse.Success(
    userId = this.userId
)

fun RegistrationRequest.toRegistrationCredentials(): Login.RegistrationCredentials =
    Login.RegistrationCredentials.newBuilder()
        .setEmail(email)
        .setName(name)
        .setPassword(password)
        .build()