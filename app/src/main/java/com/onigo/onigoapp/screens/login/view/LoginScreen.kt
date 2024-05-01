package com.onigo.onigoapp.screens.login.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.onigo.onigoapp.R
import com.onigo.onigoapp.core.Screens
import com.onigo.onigoapp.coreui.ActionButton
import com.onigo.onigoapp.coreui.AppColors
import com.onigo.onigoapp.coreui.EditTextHint
import com.onigo.onigoapp.screens.login.LoginViewModel
import com.onigo.onigoapp.screens.login.model.LoginEvent
import com.onigo.onigoapp.screens.login.model.LoginViewState
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(navController: NavHostController) {
    val viewModel: LoginViewModel = koinViewModel()
    val viewState = viewModel.viewStates().collectAsState()
    CoreView(
        state = viewState.value,
        onSend = { viewModel.obtainEvent(LoginEvent.OnSend) },
        onNumberChange = { viewModel.obtainEvent(LoginEvent.OnNumberChange(it)) }
    )
    if (viewState.value.isAvailableGoNextPage) {
        navController.navigate("${Screens.Result.name}/${viewState.value.isSuccessNumber}")
        viewModel.obtainEvent(LoginEvent.OnClearState)
    }
}

@Composable
private fun CoreView(
    state: LoginViewState,
    onSend: () -> Unit,
    onNumberChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.white)
            .padding(all = 20.dp)
    ) {
        Text(
            text = stringResource(id = R.string.enter_phone_number),
            fontSize = 28.sp,
            color = AppColors.black,
            fontWeight = FontWeight.Bold
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                EditTextHint(
                    text = state.number,
                    onTextChanged = onNumberChange,
                    textHintId = R.string.phone_number_hint,
                    keyboardType = KeyboardType.Number,
                    maxLength = 11
                )
                Text(
                    text = stringResource(id = R.string.we_will_send_sms),
                    fontSize = 15.sp,
                    color = AppColors.black
                )
            }
        }
        ActionButton(
            text = stringResource(id = R.string.send),
            state = state.buttonState,
            onClick = onSend
        )
    }
}

@Preview
@Composable
private fun CorePreview() {
    CoreView(
        state = LoginViewState(),
        onSend = {},
        onNumberChange = {}
    )
}