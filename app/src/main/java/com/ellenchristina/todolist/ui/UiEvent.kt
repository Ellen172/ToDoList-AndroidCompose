package com.ellenchristina.todolist.ui

import com.ellenchristina.todolist.navigation.AddEditRoute

sealed interface UiEvent {
    data class ShowSnackbar(val message: String) : UiEvent
    data object NavigationBack : UiEvent
    data class Navigate<T : Any>(val route: T) : UiEvent
}