package com.example.fiapp.presentation.loginscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fiapp.domain.LoginRequest
import com.example.fiapp.domain.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewmodel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    private val _state: MutableStateFlow<LoginScreenState> =
        MutableStateFlow(LoginScreenState())

    val state: StateFlow<LoginScreenState> = _state

    fun onEvent(event: LoginScreenEvent) {
        when (event) {
            is LoginScreenEvent.Login -> viewModelScope.launch {
                val response = userRepository.login(
                    LoginRequest(
                        email = _state.value.email,
                        password = _state.value.password
                    )
                )

                _state.update {
                    it.copy(loginResponse = response)
                }
            }

            is LoginScreenEvent.ChangeEmail -> {
                _state.update {
                    it.copy(email = event.email)
                }
            }

            is LoginScreenEvent.ChangePassword -> {
                _state.update {
                    it.copy(password = event.password)
                }
            }
        }
    }
}
