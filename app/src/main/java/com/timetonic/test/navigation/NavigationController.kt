package com.timetonic.test.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.timetonic.test.landing.ui.LandingScreen
import com.timetonic.test.login.ui.LoginScreen

@Composable
fun NavigationController(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        modifier = Modifier.padding(paddingValues),
        navController = navController,
        startDestination = NavigationRoutes.LoginScreen.route
    ) {
        composable(route = NavigationRoutes.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(route = NavigationRoutes.LandingScreen.route) {
            LandingScreen()
        }
    }
}
