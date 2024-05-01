package com.onigo.onigoapp.screens.result

import com.onigo.onigoapp.core.BaseMviViewModel
import com.onigo.onigoapp.screens.result.model.ResultEvent
import com.onigo.onigoapp.screens.result.model.ResultViewState

class ResultViewModel : BaseMviViewModel<ResultViewState, ResultEvent>(ResultViewState()) {
    override fun obtainEvent(viewEvent: ResultEvent) {
        when (viewEvent) {
            is ResultEvent.OnSetArguments -> onSetArgs(viewEvent.isSuccess)
        }
    }

    private fun onSetArgs(isSuccess: Boolean) {
        update { it.copy(isSuccess = isSuccess) }
    }

}