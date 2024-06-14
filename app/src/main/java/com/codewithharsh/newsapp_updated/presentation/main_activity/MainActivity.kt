package com.codewithharsh.newsapp_updated.presentation.main_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.codewithharsh.newsapp_updated.presentation.MainViewModel
import com.codewithharsh.newsapp_updated.presentation.nav_graph.NavGraph
import com.codewithharsh.newsapp_updated.presentation.ui.theme.NewsApp_UpdatedTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.splashCondition
            }
        }

        enableEdgeToEdge()
        setContent {
            NewsApp_UpdatedTheme {
                val startDestination = viewModel.startDestination
                NavGraph(startDestination = startDestination)
            }
        }
    }
}

