package com.onigo.onigoapp.screens.result.model

sealed interface ResultEvent {

    data class OnSetArguments(val isSuccess: Boolean) : ResultEvent

}