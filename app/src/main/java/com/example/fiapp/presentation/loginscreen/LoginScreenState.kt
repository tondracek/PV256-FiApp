package com.example.fiapp.presentation.loginscreen

import com.example.fiapp.domain.model.LoginResponse

data class LoginScreenState(
    val email: String = "",
    val password: String = "",
    val loginResponse: LoginResponse? = null,
)