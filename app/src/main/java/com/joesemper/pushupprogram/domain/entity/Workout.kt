package com.joesemper.pushupprogram.domain.entity

data class Workout(
    val id: Int,
    val date: Long,
    val exerciseOne: WorkoutExercise,
    val exerciseOneRepeats: Int,
    val exerciseOneRepeatsDone: Int,
    val exerciseTwo: WorkoutExercise,
    val exerciseTwoRepeats: Int,
    val exerciseTwoRepeatsDone: Int,
)
