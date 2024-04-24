package com.example.fiapp.data

import com.example.fiapp.domain.model.LoginRequest
import com.example.fiapp.domain.model.LoginResponse
import com.example.fiapp.domain.model.RegistrationRequest
import com.example.fiapp.domain.model.RegistrationResponse

interface IUserClient {

    suspend fun register(registerRequest: RegistrationRequest): RegistrationResponse

    suspend fun login(registerRequest: LoginRequest): LoginResponse
}