package com.example.fiapp.lala

import io.grpc.ManagedChannelBuilder
import parad0x.fi.proto.Login
import parad0x.fi.proto.LoginServiceGrpcKt

class UserClient(private val url: String) {
    private val port = 8081

    private val channel = ManagedChannelBuilder.forAddress(url, port).usePlaintext().build()
    private val stub = LoginServiceGrpcKt.LoginServiceCoroutineStub(channel)

    // z hladiska clean arch nie je spravne použivať builder objekty ako parameter do klienta v oboch pripadoch vytvorte nový objekt a tu ho premapujte na bulder objekt a zbuildite ho
    suspend fun register(registerRequest: Login.RegistrationCredentials.Builder): Login.UserId {
        return stub.registration(registerRequest.build())
    }

    suspend fun login(registerRequest: Login.LoginCredentials.Builder): Login.UserId {
        return stub.login(registerRequest.build())
    }
}