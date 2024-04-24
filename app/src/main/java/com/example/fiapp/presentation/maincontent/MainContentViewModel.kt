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
class MainContentViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    private val _state: MutableStateFlow<MainContentState> =
        MutableStateFlow(MainContentState())

    val state: StateFlow<MainContentState> = _state

    fun onEvent(event: MainContentEvent) {

        when (event) {
            is MainContentEvent.Register -> viewModelScope.launch {
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

            is MainContentEvent.Login -> viewModelScope.launch {
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

            is MainContentEvent.ChangeEmail -> {
                _state.update {
                    it.copy(email = event.email)
                }
            }

            is MainContentEvent.ChangeName -> {
                _state.update {
                    it.copy(name = event.username)
                }
            }

            is MainContentEvent.ChangePassword -> {
                _state.update {
                    it.copy(password = event.password)
                }
            }

            MainContentEvent.Switch -> {
//                _state.update {
//                    it.copy(isLogin = !it.isLogin)
//                }
            }
        }
    }
}
