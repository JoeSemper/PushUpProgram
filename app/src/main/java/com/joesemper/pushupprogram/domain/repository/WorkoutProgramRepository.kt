package com.joesemper.pushupprogram.domain.repository

import com.joesemper.pushupprogram.domain.entity.Program
import com.joesemper.pushupprogram.domain.entity.WorkoutSet
import com.joesemper.pushupprogram.domain.entity.WorkoutWithMuscleGroups
import kotlinx.coroutines.flow.Flow

interface WorkoutProgramRepository {
    suspend fun isEmpty(): Boolean
    suspend fun initialise()

    fun getAllPrograms(): Flow<List<Program>>
    fun getWorkoutsForProgram(programId: Int): Flow<List<WorkoutWithMuscleGroups>>
    fun getWorkoutSetsForWorkout(workoutId: Int): Flow<List<WorkoutSet>>
    fun getProgramById(programId: Int): Flow<Program>
}