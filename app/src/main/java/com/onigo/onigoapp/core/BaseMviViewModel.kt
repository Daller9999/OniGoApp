package com.onigo.onigoapp.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseMviViewModel<State, Event>(initState: State) : ViewModel() {

    protected val _viewStates: MutableStateFlow<State> = MutableStateFlow(initState)
    protected val scopeIO: CoroutineScope = CoroutineScope(Dispatchers.IO)
    val state: State
        get() = viewStates().value

    fun viewStates(): StateFlow<State> = _viewStates.asStateFlow()
    abstract fun obtainEvent(viewEvent: Event)
    protected fun update(update: (State) -> State) {
        _viewStates.update(update)
    }

    protected fun launchIO(
        call: suspend () -> Unit
    ) = viewModelScope.launch(Dispatchers.IO + SupervisorJob()) { call.invoke() }

}