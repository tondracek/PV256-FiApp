package com.example.fiapp.presentation.userhomescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fiapp.domain.UserRepository
import com.example.fiapp.presentation.navigation.Navigator
import com.example.fiapp.presentation.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class UserHomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val navigator: Navigator,
) : ViewModel() {

    val state: StateFlow<UserHomeScreenState> = userRepository.getLoggedInUser()
        .map {
            when (it) {
                null -> UserHomeScreenState.NotLoggedIn
                else -> UserHomeScreenState.Success(user = it)
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = UserHomeScreenState.Loading
        )

    fun onEvent(event: UserHomeScreenEvent) {
        when (event) {
            UserHomeScreenEvent.Logout -> {
                userRepository.logout()
//                navigator.navigateTo(Screen.UserAuth.Login)
            }

            UserHomeScreenEvent.NavigateToLogin -> {
                navigator.navigateTo(Screen.UserAuth.Login)
            }
        }
    }
}
