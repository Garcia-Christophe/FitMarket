package com.android.m2.tiila.fitmarket.domain.component

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun SetupNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.LogInScreen.route
    ) {
        composable(
            route = Screen.LogInScreen.route
        ) {
            LogInScreen(
                navHostController = navHostController
            )
        }
    }
}

sealed class Screen(val route: String) {
    object LogInScreen: Screen("com.android.m2.tiila.fitmarket.domain.component.LogInScreen")
}