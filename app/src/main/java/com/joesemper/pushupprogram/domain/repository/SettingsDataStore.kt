package com.joesemper.pushupprogram.domain.repository

import kotlinx.coroutines.flow.Flow

interface SettingsDataStore {
    suspend fun setCurrentWorkoutProgram(programId: Int)
    fun getCurrentWorkoutProgramId(): Flow<Int>
}