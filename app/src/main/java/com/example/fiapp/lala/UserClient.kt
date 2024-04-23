package com.example.fiapp.lala

import com.example.fiapp.lala.LoginUser
import com.example.fiapp.lala.RegisterUser
import io.grpc.ManagedChannelBuilder
import parad0x.fi.proto.Login
import parad0x.fi.proto.LoginServiceGrpcKt

class UserClient() {
    private val port = 50081

    private val channel =
        ManagedChannelBuilder.forAddress("89.221.215.177", port).usePlaintext().build()
    private val stub = LoginServiceGrpcKt.LoginServiceCoroutineStub(channel)

    // z hladiska clean arch nie je spravne použivať builder objekty ako parameter do klienta v oboch pripadoch vytvorte nový objekt a tu ho premapujte na bulder objekt a zbuildite ho
    suspend fun register(registerRequest: RegisterUser): Login.UserId {
        return stub.registration(
            Login.RegistrationCredentials.newBuilder().setEmail(registerRequest.email)
                .setPassword(registerRequest.password)
                .setName(registerRequest.name)
                .build()
        )
    }

    suspend fun login(loginData: LoginUser): Login.UserId {
        return stub.login(
            Login.LoginCredentials.newBuilder()
                .setPassword(loginData.password)
                .setEmail(loginData.email)
                .build()
        )
    }
}