package com.joesemper.pushupprogram.domain.entity

data class Program (
    val programId: Int,
    val durationWeeks: Int = 0,
    val programName: String = "",
    val workouts: List<Workout> = listOf()
)