package com.joesemper.pushupprogram.data.datasourse.room.main.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.*
import com.joesemper.pushupprogram.domain.entity.MuscleGroup
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutProgramDao {

    @Query("SELECT * FROM Programs")
    fun getAllPrograms(): Flow<List<DatabaseProgram>>

    @Query("SELECT * FROM Programs WHERE program_id = :programId")
    fun getProgramById(programId: Int): Flow<DatabaseProgram>

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

    @Query("SELECT * FROM Exercises WHERE exercise_id = :exerciseId")
    fun getWorkoutExerciseWithMuscleGroupById(exerciseId: Int): Flow<List<DatabaseWorkoutExerciseWithMuscleGroup>>

    @Query("SELECT * FROM Workouts WHERE program_id = :programId")
    fun getWorkoutsWithSetsForProgram(programId: Int): Flow<List<DatabaseWorkoutWithWorkoutSets>>

    @Query(
        "SELECT * " +
                "FROM Workouts " +
                "JOIN WorkoutSets ON Workouts.workout_id = WorkoutSets.workout_id " +
                "JOIN Exercises ON WorkoutSets.exercise_id = Exercises.exercise_id " +
                "JOIN MuscleGroups ON Exercises.muscle_group_id = MuscleGroups.muscle_group_id " +
                "WHERE program_id = :programId"
    )
    fun getWorkoutsForProgramWithMuscleGroups(programId: Int): Flow<Map<DatabaseWorkout, Set<DatabaseMuscleGroup>>>

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