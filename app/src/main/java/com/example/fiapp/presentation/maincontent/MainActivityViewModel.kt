package com.example.fiapp.presentation.maincontent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fiapp.domain.LoginRequest
import com.example.fiapp.domain.RegistrationRequest
import com.example.fiapp.domain.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    private val _state: MutableStateFlow<MainActivityContentState> =
        MutableStateFlow(MainActivityContentState())

    val state: StateFlow<MainActivityContentState> = _state

    fun register() = viewModelScope.launch {
        _state.update {
            it.copy(
                registrationResponse = userRepository.register(
                    RegistrationRequest(
                        email = "test_email",
                        name = "test_name",
                        password = "test_password"
                    )
                )
            )
        }
    }

    fun login() = viewModelScope.launch {
        _state.update {
            it.copy(
                loginResponse = userRepository.login(
                    LoginRequest(
                        email = "test_email",
                        password = "test_password"
                    )
                )
            )
        }
    }
}
