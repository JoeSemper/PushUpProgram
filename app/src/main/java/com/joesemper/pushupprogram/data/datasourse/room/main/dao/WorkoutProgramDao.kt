package com.joesemper.pushupprogram.data.datasourse.room.main.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.DatabaseWorkoutExercise
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.DatabaseWorkout
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.DatabaseWorkoutWithExercises
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity.PrepopulatedWorkoutExercise
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutProgramDao {
    @Query("SELECT * FROM Program")
    suspend fun getAllWorkoutDays(): List<DatabaseWorkout>

    @Query("SELECT * FROM Exercises")
    suspend fun getAllExercises(): List<DatabaseWorkoutExercise>

    @Query("SELECT * FROM Program")
    fun getAllWorkoutsWithExercises(): Flow<List<DatabaseWorkoutWithExercises>>

    @Insert
    suspend fun insertWorkoutDays(databaseWorkouts: List<DatabaseWorkout>)

    @Insert
    suspend fun insertExercises(databaseWorkoutExercises: List<DatabaseWorkoutExercise>)

    @Query("SELECT (SELECT COUNT(*) FROM Program) == 0")
    suspend fun isEmpty(): Boolean

}