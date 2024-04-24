package com.example.fiapp.domain

import com.example.fiapp.data.IUserClient
import com.example.fiapp.domain.model.LoginRequest
import com.example.fiapp.domain.model.LoginResponse
import com.example.fiapp.domain.model.RegistrationRequest
import com.example.fiapp.domain.model.RegistrationResponse
import com.example.fiapp.domain.model.User
import com.example.fiapp.domain.model.UserId
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

class UserRepository(
    private val userClient: IUserClient,
) {
    private val loggedInId: MutableStateFlow<Int?> = MutableStateFlow(null)

    fun getLoggedInUser(): Flow<User?> {
        return loggedInId.map { userId ->
            userId?.let { User(id = UserId(it)) }
        }
    }

    suspend fun register(registrationRequest: RegistrationRequest): RegistrationResponse {
        return userClient.register(registrationRequest)
    }

    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        val loginResponse = userClient.login(loginRequest)

        if (loginResponse is LoginResponse.Success) {
            loggedInId.value = loginResponse.userId
        }

        return loginResponse
    }

    fun logout() {
        loggedInId.value = null
    }
}