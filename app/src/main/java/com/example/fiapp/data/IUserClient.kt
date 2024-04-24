package com.example.fiapp.data

import com.example.fiapp.domain.LoginRequest
import com.example.fiapp.domain.LoginResponse
import com.example.fiapp.domain.RegistrationRequest
import com.example.fiapp.domain.RegistrationResponse

interface IUserClient {

    suspend fun register(registerRequest: RegistrationRequest): RegistrationResponse

    suspend fun login(registerRequest: LoginRequest): LoginResponse
}