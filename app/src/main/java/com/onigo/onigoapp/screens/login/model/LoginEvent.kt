package com.onigo.onigoapp.screens.login.model

sealed interface LoginEvent {
    data class OnNumberChange(val number: String) : LoginEvent
    data object OnSend : LoginEvent

    data object OnClearState : LoginEvent

}