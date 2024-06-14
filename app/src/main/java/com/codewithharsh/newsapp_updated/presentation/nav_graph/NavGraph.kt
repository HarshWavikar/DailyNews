package com.codewithharsh.newsapp_updated.presentation.nav_graph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.codewithharsh.newsapp_updated.presentation.onboarding.OnBoardingScreen
import com.codewithharsh.newsapp_updated.presentation.onboarding.OnBoardingViewModel

@Composable
fun NavGraph(startDestination: String) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        /*
            Here I have created two sub graphs
                 1) For onBoarding screen
                 2) For Home Screen
        */

        navigation(
            startDestination = Routes.OnBoardingScreen.route,
            route = Routes.AppStartNavigation.route
        ) {
            composable(
                route = Routes.OnBoardingScreen.route
            ) {
                val onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(event = onBoardingViewModel::onEvent)
            }
        }

        navigation(
            startDestination = Routes.NewsNavigatorScreen.route,
            route = Routes.NewsNavigation.route
        ) {
            composable(route = Routes.NewsNavigatorScreen.route) {
                Text(text = "News Navigator Screen")
            }
        }

    }
}