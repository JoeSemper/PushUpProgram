package com.joesemper.pushupprogram.data.datasourse.room.main.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.*
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity.PrepopulatedWorkoutExercise
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutProgramDao {
    @Query("SELECT * FROM Workouts")
    fun getAllWorkouts(): Flow<List<DatabaseWorkout>>

//    @Query("SELECT * FROM Exercises")
//    suspend fun getAllExercises(): List<DatabaseWorkoutExercise>

//    @Query("SELECT * FROM Programs")
//    fun getAllWorkoutsWithExercises(): Flow<List<DatabaseWorkoutWithExercises>>

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