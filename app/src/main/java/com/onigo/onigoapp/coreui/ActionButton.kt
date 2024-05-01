package com.onigo.onigoapp.coreui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onigo.onigoapp.R
import com.onigo.onigoapp.core.AppColors
import com.onigo.onigoapp.screens.login.model.ButtonState

@Composable
fun ActionButton(
    text: String,
    state: ButtonState,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable(enabled = state == ButtonState.AVAILABLE) {
                onClick.invoke()
            }
            .fillMaxWidth()
            .height(55.dp)
            .background(
                color = if (state == ButtonState.BLOCKED) {
                    AppColors.light_grey
                } else {
                    AppColors.orange
                },
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        if (state == ButtonState.LOADING) {
            CircularProgressIndicator(color = AppColors.white)
        } else {
            Text(
                text = text,
                fontSize = 15.sp,
                color = if (state == ButtonState.AVAILABLE) {
                    AppColors.white
                } else {
                    AppColors.grey
                }
            )
        }
    }
}