package com.onigo.onigoapp.screens.login.model

data class LoginViewState(
    val number: String = "",
    val buttonState: ButtonState = ButtonState.BLOCKED,
    val isSuccessNumber: Boolean = false,
    val isAvailableGoNextPage: Boolean = false
)

enum class ButtonState {
    LOADING,
    BLOCKED,
    AVAILABLE
}