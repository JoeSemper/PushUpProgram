package com.joesemper.pushupprogram.domain.repository

import com.joesemper.pushupprogram.domain.entity.Workout
import kotlinx.coroutines.flow.Flow

interface WorkoutProgramRepository {
    suspend fun isEmpty(): Boolean
    suspend fun initialise()
    suspend fun getWorkoutProgram(): Flow<List<Workout>>
}