package com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Relation
import kotlinx.parcelize.Parcelize

@Parcelize
data class WorkoutDayWithExercise(
    @Embedded
    val prepopulatedWorkoutDay: PrepopulatedWorkoutDay,
    @Relation(
        parentColumn = "exercise_one",
        entityColumn = "id"
    )
    val prepopulatedExerciseOne: PrepopulatedExercise,
    @Relation(
        parentColumn = "exercise_two",
        entityColumn = "id"
    )
    val prepopulatedExerciseTwo: PrepopulatedExercise,
) : Parcelable