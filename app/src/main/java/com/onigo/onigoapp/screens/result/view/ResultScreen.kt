package com.onigo.onigoapp.screens.result.view

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.onigo.onigoapp.R
import com.onigo.onigoapp.core.AppColors
import com.onigo.onigoapp.core.Screens
import com.onigo.onigoapp.coreui.ActionButton
import com.onigo.onigoapp.screens.login.model.ButtonState
import com.onigo.onigoapp.screens.result.ResultViewModel
import com.onigo.onigoapp.screens.result.model.ResultEvent
import com.onigo.onigoapp.screens.result.model.ResultViewState
import org.koin.androidx.compose.koinViewModel

@Composable
fun ResultScreen(args: Bundle?, navController: NavHostController) {
    val viewModel: ResultViewModel = koinViewModel()
    val viewState = viewModel.viewStates().collectAsState()
    CoreView(
        state = viewState.value,
        onGoBack = {
            navController.popBackStack()
        }
    )
    LaunchedEffect(Unit) {
        args?.let {
            viewModel.obtainEvent(
                ResultEvent.OnSetArguments(
                    isSuccess = it.getString(
                        Screens.Result.argStatus,
                        "false"
                    ).toBoolean()
                )
            )
        }
    }
}

@Composable
private fun CoreView(
    state: ResultViewState,
    onGoBack: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.white)
            .padding(20.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(
                    id = if (state.isSuccess) {
                        R.string.success
                    } else {
                        R.string.failure
                    }
                ),
                fontSize = 28.sp,
                color = AppColors.black,
                fontWeight = FontWeight.Bold
            )
        }
        ActionButton(
            text = stringResource(id = R.string.return_back),
            state = ButtonState.AVAILABLE,
            onClick = onGoBack
        )
    }
}

@Preview
@Composable
private fun CorePreviewSuccess() {
    CoreView(state = ResultViewState(true), onGoBack = {})
}

@Preview
@Composable
private fun CorePreviewFailure() {
    CoreView(state = ResultViewState(false), onGoBack = {})
}