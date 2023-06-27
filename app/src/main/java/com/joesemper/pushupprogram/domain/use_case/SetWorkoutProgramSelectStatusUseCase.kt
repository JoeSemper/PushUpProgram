package com.joesemper.pushupprogram.domain.use_case

import com.joesemper.pushupprogram.domain.repository.SettingsDataStore
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SetWorkoutProgramSelectStatusUseCase(
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val settingsDataStore: SettingsDataStore
) {
    suspend operator fun invoke(isSelected: Boolean) = withContext(defaultDispatcher) {
        settingsDataStore.setWorkoutProgramSelectedStatus(isSelected)
    }
}