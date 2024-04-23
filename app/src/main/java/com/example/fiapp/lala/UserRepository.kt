package com.example.fiapp.lala

import UserClient
import javax.inject.Inject

class UserRepository @Inject constructor(private val user: UserClient) {
    suspend fun login(email: String, password: String): Int {
        val response = user.login(
            LoginUser(email, password)
        )
        return response.userId
    }

    suspend fun register(email: String, password: String): Int {
        val response =user.register(
            registerRequest = RegisterUser("name", email, password)
        )
        return response.userId
    }
}