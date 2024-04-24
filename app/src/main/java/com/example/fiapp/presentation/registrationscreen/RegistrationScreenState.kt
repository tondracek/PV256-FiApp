package com.example.fiapp.presentation.registrationscreen

import com.example.fiapp.domain.model.LoginResponse
import com.example.fiapp.domain.model.RegistrationResponse

data class RegistrationScreenState(
    val name: String = "",
    val email: String = "",
    val password: String = "",

    val loginResponse: LoginResponse? = null,
    val registrationResponse: RegistrationResponse? = null,
)
