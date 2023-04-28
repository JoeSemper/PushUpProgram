package com.joesemper.pushupprogram.domain.entity

data class WorkoutExercise(
    val exercise_id: Int,
    val exerciseName: String = "",
    val muscleGroupId: MuscleGroup,
    val description: String = ""
)