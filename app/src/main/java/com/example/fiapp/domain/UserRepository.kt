package com.example.fiapp.domain

import com.example.fiapp.data.UserClient
import parad0x.fi.proto.Login

class UserRepository(
    private val userClient: UserClient,
) {

    suspend fun register(registrationRequest: RegistrationRequest): RegistrationResponse {

        val registrationCredentials: Login.RegistrationCredentials =
            registrationRequest.toRegistrationCredentials()

        return try {
            userClient
                .register(registrationCredentials)
                .toRegistrationResponse()
        } catch (e: Exception) {
            RegistrationResponse.Error(e.message ?: "Unknown error")
        }
    }

    suspend fun login(loginRequest: LoginRequest): LoginResponse {

        val loginCredentials: Login.LoginCredentials =
            loginRequest.toLoginCredentials()

        return try {
            userClient
                .login(loginCredentials)
                .toLoginResponse()
        } catch (e: Exception) {
            LoginResponse.Error(e.message ?: "Unknown error")
        }
    }
}