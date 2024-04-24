package com.example.fiapp.presentation.registrationscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fiapp.domain.RegistrationRequest
import com.example.fiapp.domain.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationScreenViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    private val _state: MutableStateFlow<RegistrationScreenState> =
        MutableStateFlow(RegistrationScreenState())

    val state: StateFlow<RegistrationScreenState> = _state

    fun onEvent(event: RegistrationScreenEvent) {
        when (event) {
            is RegistrationScreenEvent.Register -> viewModelScope.launch {
                val response = userRepository.register(
                    RegistrationRequest(
                        email = _state.value.email,
                        name = _state.value.name,
                        password = _state.value.password
                    )
                )

                _state.update {
                    it.copy(registrationResponse = response)
                }
            }

            is RegistrationScreenEvent.ChangeEmail -> {
                _state.update {
                    it.copy(email = event.email)
                }
            }

            is RegistrationScreenEvent.ChangeName -> {
                _state.update {
                    it.copy(name = event.username)
                }
            }

            is RegistrationScreenEvent.ChangePassword -> {
                _state.update {
                    it.copy(password = event.password)
                }
            }
        }
    }
}
