package com.codewithharsh.newsapp_updated.domain.usecases.app_entry

import com.codewithharsh.newsapp_updated.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
     operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}