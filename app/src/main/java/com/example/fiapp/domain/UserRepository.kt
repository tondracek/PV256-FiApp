package com.example.fiapp.domain

import com.example.fiapp.data.IUserClient

class UserRepository(
    private val userClient: IUserClient,
) {
    suspend fun register(registrationRequest: RegistrationRequest): RegistrationResponse {
        return userClient.register(registrationRequest)
    }

    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return userClient.login(loginRequest)
    }
}