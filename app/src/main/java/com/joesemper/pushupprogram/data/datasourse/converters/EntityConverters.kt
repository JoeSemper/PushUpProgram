package com.joesemper.pushupprogram.data.datasourse.converters

import com.joesemper.pushupprogram.data.datasourse.room.main.entity.*
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity.*
import com.joesemper.pushupprogram.domain.entity.*

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

fun DatabaseWorkoutExerciseWithMuscleGroup.toWorkoutExercise() = WorkoutExercise(
    exerciseId = databaseWorkoutExercise.exerciseId,
    exerciseName = databaseWorkoutExercise.exerciseName,
    muscleGroupId = databaseWorkoutExercise.muscleGroupId,
    muscleGroup = databaseMuscleGroup.toMuscleGroup(),
    description = databaseWorkoutExercise.description

)

fun DatabaseWorkoutSetWithExercise.toWorkoutSet() = WorkoutSet(
    workoutSetId = databaseWorkoutSet.workoutSetId,
    workoutId = databaseWorkoutSet.workoutId,
    exercise = databaseWorkoutExercise.toWorkoutExercise(),
    exerciseReps = databaseWorkoutSet.exerciseReps
)

fun DatabaseMuscleGroup.toMuscleGroup() = MuscleGroup(
    muscleGroupId = muscleGroupId,
    muscleGroupName = muscleGroupName
)

fun DatabaseWorkoutWithWorkoutSets.toWorkout() = Workout(
    workoutId = databaseWorkout.workoutId,
    programId = databaseWorkout.programId,
    date = databaseWorkout.date,
    dayInWeek = databaseWorkout.dayInWeek,
    workoutSets = databaseWorkoutSets.map { it.toWorkoutSet() }

)