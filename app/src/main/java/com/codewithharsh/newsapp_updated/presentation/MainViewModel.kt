package com.codewithharsh.newsapp_updated.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codewithharsh.newsapp_updated.domain.usecases.app_entry.AppEntryUseCases
import com.codewithharsh.newsapp_updated.presentation.nav_graph.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
) : ViewModel() {

    /* Here we determine the start destination of the app,
     for that we get the value of the appEntry key from the
     datastore preferences and check if it is true then we
     navigate to NewsNavigatorScreen else we navigate to
     OnBoardingScreen */

    var splashCondition by mutableStateOf(true)
    private set

    var startDestination by mutableStateOf(Routes.AppStartNavigation.route)
        private set

    init {
        appEntryUseCases.readAppEntry().onEach { shouldStartFromHomeScreen ->
            if (shouldStartFromHomeScreen) {
                startDestination = Routes.NewsNavigation.route
            } else {
                startDestination = Routes.AppStartNavigation.route
            }
            delay(300)
            splashCondition = false
        }.launchIn(viewModelScope)
    }
}