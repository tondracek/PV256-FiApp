package com.example.fiapp.presentation.maincontent

import com.example.fiapp.domain.LoginResponse
import com.example.fiapp.domain.RegistrationResponse

data class MainContentState(
    val name: String = "",
    val email: String = "",
    val password: String = "",

    val loginResponse: LoginResponse? = null,
    val registrationResponse: RegistrationResponse? = null,
)
