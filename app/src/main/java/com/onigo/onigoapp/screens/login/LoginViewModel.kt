package com.onigo.onigoapp.screens.login

import com.onigo.onigoapp.core.BaseMviViewModel
import com.onigo.onigoapp.screens.login.model.ButtonState
import com.onigo.onigoapp.screens.login.model.LoginEvent
import com.onigo.onigoapp.screens.login.model.LoginViewState
import com.onigo.repository.OniGoRepository
import kotlinx.coroutines.delay

class LoginViewModel(
    private val oniGoRepository: OniGoRepository
) : BaseMviViewModel<LoginViewState, LoginEvent>(LoginViewState()) {

    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.OnNumberChange -> onNumberChange(viewEvent.number)
            LoginEvent.OnSend -> onSend()
            LoginEvent.OnClearState -> update { LoginViewState() }
        }
    }

    private fun onSend() = launchIO {
        update { it.copy(buttonState = ButtonState.LOADING) }
        val result = oniGoRepository.requestNumber(state.number)
        update {
            it.copy(
                isSuccessNumber = result.data != null,
                isAvailableGoNextPage = true
            )
        }
    }

    private fun onNumberChange(number: String) = update {
        it.copy(
            number = number,
            buttonState = if (number.length == 11) ButtonState.AVAILABLE else ButtonState.BLOCKED
        )
    }

}