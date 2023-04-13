package com.joesemper.pushupprogram.data.repository

import com.joesemper.pushupprogram.data.datasourse.converters.databaseWorkoutToWorkout
import com.joesemper.pushupprogram.data.datasourse.converters.prepopulatedExerciseToExercise
import com.joesemper.pushupprogram.data.datasourse.converters.prepopulatedWorkoutToDatabaseWorkout
import com.joesemper.pushupprogram.data.datasourse.room.main.dao.WorkoutProgramDao
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.dao.PrepopulatedProgramDao
import com.joesemper.pushupprogram.domain.entity.Workout
import com.joesemper.pushupprogram.domain.repository.WorkoutProgramRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.java.KoinJavaComponent.inject


class WorkoutProgramRepositoryImpl(
    private val workoutProgramDao: WorkoutProgramDao
) : WorkoutProgramRepository {

    override suspend fun isEmpty() = workoutProgramDao.isEmpty()

    override suspend fun initialise() {
        val prepopulatedProgramDao: PrepopulatedProgramDao by inject(PrepopulatedProgramDao::class.java)

        val exercises = prepopulatedProgramDao.getAllWorkoutExercises()
        val workouts = prepopulatedProgramDao.getAllWorkoutDays()

        workoutProgramDao.apply {
            insertExercises(exercises.map { prepopulatedExerciseToExercise(it) })
            insertWorkoutDays(workouts.map { prepopulatedWorkoutToDatabaseWorkout(it) })
        }
    }

    override suspend fun getWorkoutProgram(): Flow<List<Workout>> {
        return workoutProgramDao.getAllWorkoutsWithExercises().map { workouts ->
            workouts.map { databaseWorkoutToWorkout(it) }
        }
    }
}