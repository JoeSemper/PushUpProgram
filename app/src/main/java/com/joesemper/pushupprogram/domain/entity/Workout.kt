package com.joesemper.pushupprogram.domain.entity

data class Workout(
    val workoutId: Int,
    val date: Long = 0,
    val exercise: WorkoutExercise,
    val dayInWeek: Int = 0,
)
