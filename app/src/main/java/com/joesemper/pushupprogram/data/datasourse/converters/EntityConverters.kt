package com.joesemper.pushupprogram.data.datasourse.converters

import com.joesemper.pushupprogram.data.datasourse.room.main.entity.*
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity.*
import com.joesemper.pushupprogram.domain.entity.Program
import com.joesemper.pushupprogram.domain.entity.Workout
import com.joesemper.pushupprogram.domain.entity.WorkoutExercise
import com.joesemper.pushupprogram.domain.entity.WorkoutSet

fun prepopulatedWorkoutToDatabaseWorkout(prepopulatedWorkout: PrepopulatedWorkout) =
    with(prepopulatedWorkout) {
        DatabaseWorkout(
            workoutId = workoutId ?: 0,
            date = 0,
            dayInWeek = dayInWeek ?: 0,
            programId = programId ?: 0
        )
    }

fun prepopulatedExerciseToDatabaseExercise(prepopulatedExercise: PrepopulatedWorkoutExercise) =
    with(prepopulatedExercise) {
        DatabaseWorkoutExercise(
            exerciseId = exerciseId ?: 0,
            exerciseName = exerciseName ?: "",
            muscleGroupId = muscleGroupId ?: 0,
            description = description ?: ""
        )
    }

fun prepopulatedMuscleGroupToDatabaseMuscleGroup(prepopulatedMuscleGroup: PrepopulatedMuscleGroup) =
    with(prepopulatedMuscleGroup) {
        DatabaseMuscleGroup(
            muscleGroupId = muscleGroupId ?: 0,
            muscleGroupName = muscleGroupName ?: ""
        )
    }

fun prepopulatedWorkoutSetToDatabaseWorkoutSet(prepopulatedWorkoutSet: PrepopulatedWorkoutSet) =
    with(prepopulatedWorkoutSet) {
        DatabaseWorkoutSet(
            workoutSetId = workoutSetId ?: 0,
            workoutId = workoutId ?: 0,
            exerciseId = exerciseId ?: 0,
            exerciseReps = exerciseReps ?: 0
        )
    }

fun prepopulatedProgramToDatabaseProgram(prepopulatedProgram: PrepopulatedProgram) =
    with(prepopulatedProgram) {
        DatabaseProgram(
            programId = programId ?: 0,
            durationWeeks = durationWeeks ?: 0,
            programName = programName ?: ""
        )
    }

fun DatabaseProgram.toProgram() = Program(
    programId = programId,
    durationWeeks = durationWeeks,
    programName = programName
)

fun DatabaseWorkout.toWorkout() = Workout(
    workoutId = workoutId,
    programId = programId,
    date = date,
    dayInWeek = dayInWeek,
)

fun DatabaseWorkoutExercise.toWorkoutExercise() = WorkoutExercise(
    exerciseId = exerciseId,
    exerciseName = exerciseName,
    muscleGroupId = muscleGroupId,
    description = description
)

fun DatabaseWorkoutSetWithExercise.toWorkoutSet() = WorkoutSet(
    workoutSetId = databaseWorkoutSet.workoutSetId,
    workoutId = databaseWorkoutSet.workoutId,
    exercise = databaseWorkoutExercise.toWorkoutExercise(),
    exerciseReps = databaseWorkoutSet.exerciseReps
)


//fun databaseWorkoutToWorkout(workoutWithExercises: DatabaseWorkoutWithExercises) =
//    with(workoutWithExercises) {
//        Workout(
//            id = databaseWorkout.id,
//            date = databaseWorkout.date,
//            exerciseOne = databaseExerciseToExercise(databaseWorkoutExerciseOne),
//            exerciseOneRepeats = databaseWorkout.exerciseOneRepeats,
//            exerciseOneRepeatsDone = databaseWorkout.exerciseOneRepeatsDone,
//            exerciseTwo = databaseExerciseToExercise(databaseWorkoutExerciseTwo),
//            exerciseTwoRepeats = databaseWorkout.exerciseTwoRepeats,
//            exerciseTwoRepeatsDone = databaseWorkout.exerciseTwoRepeatsDone
//        )
//    }
//
//fun databaseExerciseToExercise(exercise: DatabaseWorkoutExercise) = with(exercise) {
//    WorkoutExercise(
//        id = id,
//        exerciseNameResId = exerciseNameToResId(exerciseName)
//    )
//}
//
//fun exerciseNameToResId(exerciseName: String) = when (exerciseName) {
//    "Back" -> R.string.back
//    "Chest" -> R.string.chest
//    else -> R.string.rest
//}
