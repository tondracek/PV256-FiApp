package com.example.fiapp.data

import com.example.fiapp.domain.LoginRequest
import com.example.fiapp.domain.LoginResponse
import com.example.fiapp.domain.RegistrationRequest
import com.example.fiapp.domain.RegistrationResponse
import com.example.fiapp.domain.toLoginCredentials
import com.example.fiapp.domain.toLoginResponse
import com.example.fiapp.domain.toRegistrationCredentials
import com.example.fiapp.domain.toRegistrationResponse
import io.grpc.ManagedChannelBuilder
import parad0x.fi.proto.LoginServiceGrpcKt

class UserClient : IUserClient {
    private val address = "89.221.215.177"
    private val port = 50081

    private val channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build()
    private val stub = LoginServiceGrpcKt.LoginServiceCoroutineStub(channel)

    override suspend fun register(registerRequest: RegistrationRequest): RegistrationResponse {
        val registrationCredentials = registerRequest.toRegistrationCredentials()

        return try {
            val response = stub.registration(registrationCredentials)
            response.toRegistrationResponse()
        } catch (e: Exception) {
            RegistrationResponse.Error(e.message ?: "Unknown error")
        }
    }

    override suspend fun login(registerRequest: LoginRequest): LoginResponse {
        val loginCredentials = registerRequest.toLoginCredentials()

        return try {
            val response = stub.login(loginCredentials)
            response.toLoginResponse()
        } catch (e: Exception) {
            LoginResponse.Error(e.message ?: "Unknown error")
        }
    }
}
