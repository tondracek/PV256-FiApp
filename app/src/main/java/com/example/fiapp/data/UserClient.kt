package com.example.fiapp.data

import com.example.fiapp.domain.model.LoginRequest
import com.example.fiapp.domain.model.LoginResponse
import com.example.fiapp.domain.model.RegistrationRequest
import com.example.fiapp.domain.model.RegistrationResponse
import com.example.fiapp.domain.model.toLoginCredentials
import com.example.fiapp.domain.model.toLoginResponse
import com.example.fiapp.domain.model.toRegistrationCredentials
import com.example.fiapp.domain.model.toRegistrationResponse
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
            if (response.userId == 0) {
                return LoginResponse.Error("Invalid password")
            }
            response.toLoginResponse()
        } catch (e: Exception) {
            LoginResponse.Error(e.message ?: "Unknown error")
        }
    }
}
