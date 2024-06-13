package com.codewithharsh.newsapp_updated.di

import android.app.Application
import com.codewithharsh.newsapp_updated.data.manager.LocalUserManagerImpl
import com.codewithharsh.newsapp_updated.domain.manager.LocalUserManager
import com.codewithharsh.newsapp_updated.domain.usecases.AppEntryUseCases
import com.codewithharsh.newsapp_updated.domain.usecases.ReadAppEntry
import com.codewithharsh.newsapp_updated.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager {
        return LocalUserManagerImpl(application)
    }

    @Provides
    @Singleton
    fun provideAppEntryUseCases(localUserManager: LocalUserManager): AppEntryUseCases {
        return AppEntryUseCases(
            readAppEntry = ReadAppEntry(localUserManager),
            saveAppEntry = SaveAppEntry(localUserManager)
        )
    }
}