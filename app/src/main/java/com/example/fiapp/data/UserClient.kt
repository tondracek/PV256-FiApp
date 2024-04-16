package com.example.fiapp.data

import io.grpc.ManagedChannelBuilder
import parad0x.fi.proto.Login
import parad0x.fi.proto.LoginServiceGrpcKt

class UserClient {
    private val port = 50081

    private val channel =
        ManagedChannelBuilder.forAddress("89.221.215.177", port).usePlaintext().build()
    private val stub = LoginServiceGrpcKt.LoginServiceCoroutineStub(channel)

    // z hladiska clean arch nie je spravne použivať builder objekty ako parameter do klienta v oboch pripadoch vytvorte nový objekt a tu ho premapujte na bulder objekt a zbuildite ho
    suspend fun register(registerRequest: Login.RegistrationCredentials): Login.UserId {
        return stub.registration(registerRequest)
    }

    suspend fun login(registerRequest: Login.LoginCredentials): Login.UserId {
        return stub.login(registerRequest)
    }
}