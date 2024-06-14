package com.codewithharsh.newsapp_updated.presentation.nav_graph

sealed class Routes(
    val route: String
) {
    object OnBoardingScreen : Routes("onboarding_screen")
    object Home : Routes("home_screen")
    object Search : Routes("search_screen")
    object Bookmark : Routes("bookmark_screen")
    object Details : Routes("details_screen")
    object AppStartNavigation : Routes("app_start_navigation")
    object NewsNavigation : Routes("news_navigation")
    object NewsNavigatorScreen : Routes("news_navigator_screen")

}