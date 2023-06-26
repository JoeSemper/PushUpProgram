package com.joesemper.pushupprogram.data.datasourse.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.joesemper.pushupprogram.domain.repository.SettingsDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SettingsDataStoreImpl(private val context: Context): SettingsDataStore {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

        private val CURRENT_PROGRAM = stringPreferencesKey("current_program")
        private const val DEFAULT_PROGRAM_ID = 1
    }

    override suspend fun setCurrentWorkoutProgram(programId: Int) {
        context.dataStore.edit { settings ->
            settings[CURRENT_PROGRAM] = programId.toString()
        }
    }

    override fun getCurrentWorkoutProgramId(): Flow<Int> = context.dataStore.data.map { preferences ->
        preferences[CURRENT_PROGRAM]?.toInt() ?: DEFAULT_PROGRAM_ID
    }

}