package com.example.fiapp

import android.os.UserManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fiapp.lala.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed class Actions {
    data class OnNameKeywordChange(val keyword: String) : Actions()
    data class OnEmailKeywordChange(val keyword: String) : Actions()
    data class OnPasswordKeywordChange(val keyword: String) : Actions()
    data object Login : Actions()
    data object Register : Actions()
    data object Switch : Actions()
}
data class LoginUiState(val loggedIn: Boolean = false)

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userManager: UserRepository,
) : ViewModel() {

    val uiState = MutableStateFlow(LoginUiState())

    private val _uiState = MutableStateFlow(LoginUiState())

    init {
        login()
    }

    fun emitEvent(event: Actions) {
        when (event) {
            Actions.Login -> TODO()
            is Actions.OnEmailKeywordChange -> _uiState.update { it.copy() }
            is Actions.OnNameKeywordChange -> TODO()
            is Actions.OnPasswordKeywordChange -> TODO()
            Actions.Register -> TODO()
            Actions.Switch -> TODO()
        }
    }
    fun login() {
        viewModelScope.launch(Dispatchers.IO) {
            userManager.login("email", "pass")
            uiState.update { it.copy(loggedIn = true) }
        }
    }

    fun register() {
        viewModelScope.launch(Dispatchers.IO) {
            userManager.register("name", "pass")
            uiState.update { it.copy(loggedIn = true) }
        }
    }
}
