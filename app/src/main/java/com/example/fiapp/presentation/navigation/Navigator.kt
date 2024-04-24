package com.example.fiapp.presentation.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class Navigator {

    private val _sharedFlow = MutableSharedFlow<Screen>(extraBufferCapacity = 1)
    val sharedFlow: SharedFlow<Screen> = _sharedFlow.asSharedFlow()

    fun navigateTo(screen: Screen) {
        _sharedFlow.tryEmit(screen)
    }
}
