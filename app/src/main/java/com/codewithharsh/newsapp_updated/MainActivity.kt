package com.codewithharsh.newsapp_updated

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.codewithharsh.newsapp_updated.domain.usecases.AppEntryUseCases
import com.codewithharsh.newsapp_updated.presentation.onboarding.OnBoardingScreen
import com.codewithharsh.newsapp_updated.presentation.onboarding.OnBoardingViewModel
import com.codewithharsh.newsapp_updated.ui.theme.NewsApp_UpdatedTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.launch
import javax.inject.Inject
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var appEntryUseCases: AppEntryUseCases

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        lifecycleScope.launch {
            appEntryUseCases.readAppEntry().collect {
                Log.d("TAG", it.toString())
            }
        }
        enableEdgeToEdge()
        setContent {
            NewsApp_UpdatedTheme {
                val onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(event = onBoardingViewModel::onEvent)
            }
        }
    }
}

