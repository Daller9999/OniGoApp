package com.onigo.onigoapp.coreui

import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import com.onigo.onigoapp.core.AppDimens

val cardZeroElevation: CardElevation
    @Composable
    get() = CardDefaults.cardElevation(
        defaultElevation = AppDimens.size0,
        pressedElevation = AppDimens.size0,
        focusedElevation = AppDimens.size0,
        hoveredElevation = AppDimens.size0,
        draggedElevation = AppDimens.size0,
        disabledElevation = AppDimens.size0
    )