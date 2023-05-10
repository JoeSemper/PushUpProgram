package com.joesemper.pushupprogram.data.datasourse.room.main.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutProgramDao {

    @Query("SELECT * FROM Programs")
    fun getAllPrograms(): Flow<List<DatabaseProgram>>

    @Query("SELECT * FROM Workouts")
    fun getAllWorkouts(): Flow<List<DatabaseWorkout>>

    @Query("SELECT * FROM Workouts WHERE program_id = :programId")
    fun getWorkoutsForProgram(programId: Int): Flow<List<DatabaseWorkout>>

    @Query("SELECT * FROM WorkoutSets WHERE workout_id = :workoutId")
    fun getWorkoutSetsForWorkout(workoutId: Int): Flow<List<DatabaseWorkoutSet>>

    @Query("SELECT * FROM Exercises WHERE exercise_id = :exerciseId")
    fun getWorkoutExerciseById(exerciseId: Int): Flow<DatabaseWorkoutExercise>

    @Query("SELECT * FROM MuscleGroups WHERE muscle_group_id = :muscleGroupId")
    fun getMuscleGroupById(muscleGroupId: Int): Flow<DatabaseMuscleGroup>

    @Query("SELECT * FROM WorkoutSets WHERE workout_id = :workoutId")
    fun getWorkoutSetsWithExercises(workoutId: Int): Flow<List<DatabaseWorkoutSetWithExercise>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkouts(databaseWorkouts: List<DatabaseWorkout>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercises(databaseExercises: List<DatabaseWorkoutExercise>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkoutSets(databaseWorkoutSets: List<DatabaseWorkoutSet>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMuscleGroups(databaseMuscleGroup: List<DatabaseMuscleGroup>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPrograms(databasePrograms: List<DatabaseProgram>)

    @Query("SELECT (SELECT COUNT(*) FROM Programs) == 0")
    suspend fun isEmpty(): Boolean



}