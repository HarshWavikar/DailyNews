package com.codewithharsh.newsapp_updated.presentation.onboarding

sealed class OnBoardingEvent {
        data object SaveAppEntry : OnBoardingEvent()
}