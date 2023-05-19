package com.joesemper.pushupprogram.domain.entity

data class WorkoutWithMuscleGroups(
    val workoutId: Int,
    val programId: Int,
    val date: Long,
    val dayInProgram: Int,
    val muscleGroups: Set<MuscleGroup>
)