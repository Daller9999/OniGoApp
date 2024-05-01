package com.onigo.onigoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.onigo.onigoapp.core.Screens
import com.onigo.onigoapp.screens.login.view.LoginScreen
import com.onigo.onigoapp.screens.result.view.ResultScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screens.Login.name
            ) {
                composable(Screens.Login.name) {
                    LoginScreen(navController)
                }
                composable("${Screens.Result.name}/{${Screens.Result.argStatus}}") {
                    ResultScreen(
                        args = it.arguments,
                        navController = navController
                    )
                }
            }
        }
    }
}