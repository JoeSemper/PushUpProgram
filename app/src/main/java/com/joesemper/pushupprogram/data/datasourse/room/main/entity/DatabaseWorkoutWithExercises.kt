package com.joesemper.pushupprogram.data.datasourse.room.main.entity

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Relation
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity.PrepopulatedWorkout
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity.PrepopulatedWorkoutExercise
import kotlinx.parcelize.Parcelize

@Parcelize
data class DatabaseWorkoutWithExercises(
    @Embedded
    val databaseWorkout: DatabaseWorkout,
    @Relation(
        parentColumn = "exercise_one",
        entityColumn = "id"
    )
    val databaseWorkoutExerciseOne: DatabaseWorkoutExercise,
    @Relation(
        parentColumn = "exercise_two",
        entityColumn = "id"
    )
    val databaseWorkoutExerciseTwo: DatabaseWorkoutExercise,
) : Parcelable