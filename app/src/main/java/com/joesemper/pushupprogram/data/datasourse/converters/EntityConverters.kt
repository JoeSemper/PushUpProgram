package com.joesemper.pushupprogram.data.datasourse.converters

import com.joesemper.pushupprogram.R
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.DatabaseWorkout
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.DatabaseWorkoutExercise
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.DatabaseWorkoutWithExercises
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity.PrepopulatedWorkout
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity.PrepopulatedWorkoutExercise
import com.joesemper.pushupprogram.domain.entity.Workout
import com.joesemper.pushupprogram.domain.entity.WorkoutExercise

fun prepopulatedWorkoutToDatabaseWorkout(prepopulatedWorkout: PrepopulatedWorkout) =
    with(prepopulatedWorkout) {
        DatabaseWorkout(
            id = id ?: 0,
            exerciseOne = exerciseOne,
            exerciseOneRepeats = exerciseOneRepeats ?: 0,
            exerciseTwo = exerciseTwo,
            exerciseTwoRepeats = exerciseTwoRepeats ?: 0,
        )
    }

fun prepopulatedExerciseToExercise(prepopulatedExercise: PrepopulatedWorkoutExercise) =
    with(prepopulatedExercise) {
        DatabaseWorkoutExercise(
            id = id ?: 0,
            exerciseName = exerciseName ?: ""
        )
    }

fun databaseWorkoutToWorkout(workoutWithExercises: DatabaseWorkoutWithExercises) =
    with(workoutWithExercises) {
        Workout(
            id = databaseWorkout.id,
            date = databaseWorkout.date,
            exerciseOne = databaseExerciseToExercise(databaseWorkoutExerciseOne),
            exerciseOneRepeats = databaseWorkout.exerciseOneRepeats,
            exerciseOneRepeatsDone = databaseWorkout.exerciseOneRepeatsDone,
            exerciseTwo = databaseExerciseToExercise(databaseWorkoutExerciseTwo),
            exerciseTwoRepeats = databaseWorkout.exerciseTwoRepeats,
            exerciseTwoRepeatsDone = databaseWorkout.exerciseTwoRepeatsDone
        )
    }

fun databaseExerciseToExercise(exercise: DatabaseWorkoutExercise) = with(exercise) {
    WorkoutExercise(
        id = id,
        exerciseNameResId = exerciseNameToResId(exerciseName)
    )
}

fun exerciseNameToResId(exerciseName: String) = when (exerciseName) {
    "Back" -> R.string.back
    "Chest" -> R.string.chest
    else -> R.string.rest
}
