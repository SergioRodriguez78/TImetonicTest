package com.timetonic.test.navigation

sealed class NavigationRoutes (val route: String) {
    data object LoginScreen : NavigationRoutes("LoginScreen")
    data object LandingScreen: NavigationRoutes("LandingScreen")
}
