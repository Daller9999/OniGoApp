package com.onigo.onigoapp.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.onigo.onigoapp.R

object AppColors {

    val black: Color
        @Composable
        get() = colorResource(id = R.color.black)

    val grey: Color
        @Composable
        get() = colorResource(id = R.color.grey)

    val light_grey: Color
        @Composable
        get() = colorResource(id = R.color.light_grey)

    val orange: Color
        @Composable
        get() = colorResource(id = R.color.orange)

    val white: Color
        @Composable
        get() = colorResource(id = R.color.white)

}