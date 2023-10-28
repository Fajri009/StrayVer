package com.fajri.strayver.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.fajri.strayver.util.Key
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = Key.ONBOARD_KEY)

class OnBoardRepository(context: Context) {
    private val dataStore= context.dataStore
    val onBoardIsCompletedKey = booleanPreferencesKey(Key.ONBOARD_COMPLETE_KEY)

    val isCompleted: Flow<Boolean> =
        dataStore.data
            .map { pref ->
                pref[onBoardIsCompletedKey] ?: false
            }

    suspend fun setCompleted() {
        dataStore.edit { pref ->
            pref[onBoardIsCompletedKey]= true
        }
    }
}