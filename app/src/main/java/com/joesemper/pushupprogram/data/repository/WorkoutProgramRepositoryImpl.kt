package com.joesemper.pushupprogram.data.repository

import com.joesemper.pushupprogram.data.datasourse.converters.*
import com.joesemper.pushupprogram.data.datasourse.room.main.dao.WorkoutProgramDao
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.DatabaseWorkout
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

        val muscleGroups = prepopulatedProgramDao.getAllMuscleGroups()
        val exercises = prepopulatedProgramDao.getAllWorkoutExercises()
        val workoutSets = prepopulatedProgramDao.getAllWorkoutSets()
        val workouts = prepopulatedProgramDao.getAllWorkouts()
        val programs = prepopulatedProgramDao.getAllPrograms()

        workoutProgramDao.apply {
            insertMuscleGroups(muscleGroups.map { prepopulatedMuscleGroupToDatabaseMuscleGroup(it)})
            insertPrograms(programs.map { prepopulatedProgramToDatabaseProgram(it) })
            insertWorkouts(workouts.map { prepopulatedWorkoutToDatabaseWorkout(it) })
            insertExercises(exercises.map { prepopulatedExerciseToDatabaseExercise(it) })
            insertWorkoutSets(workoutSets.map { prepopulatedWorkoutSetToDatabaseWorkoutSet(it) })
        }
    }

    override fun getWorkoutSetsForWorkout(workoutId: Int): Flow<List<Workout>> {
        TODO("Not yet implemented")
    }

    override fun getWorkoutsForProgram(programId: Int): Flow<List<Workout>> {
        TODO("Not yet implemented")
    }


//    override suspend fun getWorkoutProgram(): Flow<List<Workout>> {
//        return workoutProgramDao.getAllWorkoutsWithExercises().map { workouts ->
//            workouts.map { databaseWorkoutToWorkout(it) }
//        }

}