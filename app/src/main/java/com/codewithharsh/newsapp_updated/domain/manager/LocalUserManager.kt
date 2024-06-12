package com.codewithharsh.newsapp_updated.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {
    //In this interface we want to save the app entry when the user clicks on the getStarted on the last onBoarding screen
    suspend fun saveAppEntry()
    fun readAppEntry(): Flow<Boolean>
}