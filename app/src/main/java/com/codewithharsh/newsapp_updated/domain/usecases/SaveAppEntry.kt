package com.codewithharsh.newsapp_updated.domain.usecases

import com.codewithharsh.newsapp_updated.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}