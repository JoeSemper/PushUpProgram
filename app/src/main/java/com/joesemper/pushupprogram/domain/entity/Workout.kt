package com.joesemper.pushupprogram.domain.entity

data class Workout(
    val workoutId: Int,
    val programId: Int,
    val date: Long = 0,
    val dayInWeek: Int = 0,
    val workoutSets: List<WorkoutSet> = listOf()
)
