package com.onigo.onigoapp.core

sealed class Screens(val name: String) {

    data object Login : Screens("Login")
    data object Result : Screens("Result") {
        const val argStatus = "status"
    }

}