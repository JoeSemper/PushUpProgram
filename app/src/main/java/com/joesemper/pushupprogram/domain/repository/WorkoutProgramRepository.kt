package com.joesemper.pushupprogram.domain.repository

import com.joesemper.pushupprogram.domain.entity.Workout
import kotlinx.coroutines.flow.Flow

interface WorkoutProgramRepository {
    suspend fun isEmpty(): Boolean
    suspend fun initialise()

    fun getWorkoutsForProgram(programId: Int): Flow<List<Workout>>
    fun getWorkoutSetsForWorkout(workoutId: Int): Flow<List<Workout>>
}