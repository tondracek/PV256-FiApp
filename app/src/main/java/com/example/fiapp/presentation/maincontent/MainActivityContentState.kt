package com.example.fiapp.presentation.maincontent

import com.example.fiapp.domain.LoginResponse
import com.example.fiapp.domain.RegistrationResponse

data class MainActivityContentState(
    val loginResponse: LoginResponse? = null,
    val registrationResponse: RegistrationResponse? = null,
)