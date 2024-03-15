package com.android.m2.tiila.fitmarket.domain.component

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.m2.tiila.fitmarket.domain.model.FitMarketViewModel

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun SetupNavGraph(navHostController: NavHostController, fitMarketViewModel: FitMarketViewModel) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.LogInScreen.route,
    ) {
        composable(
            route = Screen.LogInScreen.route
        ) {
            LogInScreen(
                navHostController = navHostController,
                fitMarketViewModel = fitMarketViewModel
            )
        }
        composable(
            route = Screen.ListClassesScreen.route
        ) {
            ListClassesScreen(
                navHostController = navHostController,
                fitMarketViewModel = fitMarketViewModel
            )
        }
    }
}

sealed class Screen(val route: String) {
    object LogInScreen: Screen("LogInScreen")
    object ListClassesScreen: Screen("ListClassesScreen")
}