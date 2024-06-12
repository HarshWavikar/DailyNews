package com.codewithharsh.newsapp_updated.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.codewithharsh.newsapp_updated.core.Constants.APP_ENTRY_KEY
import com.codewithharsh.newsapp_updated.core.Constants.USER_SETTINGS
import com.codewithharsh.newsapp_updated.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Here we are going to use dataStore preferences,
// DataStore preferences is a jetpack library that allows us to store key-value pairs locally on a device.
class LocalUserManagerImpl(
    private val context: Context
) : LocalUserManager {
    override suspend fun saveAppEntry() {
        context.dataStore.edit { settings ->
            settings[PreferencesKeys.APP_ENTRY] = true
        }
    }


    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferencesKeys.APP_ENTRY] ?: false
        }
    }
}

// We want to have instance of datastore
// we can simply access dataStore using context
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

// To be able to save key-value inside our datastore preferences we need preferences keys
private object PreferencesKeys {
    val APP_ENTRY = booleanPreferencesKey(name = APP_ENTRY_KEY)
}
