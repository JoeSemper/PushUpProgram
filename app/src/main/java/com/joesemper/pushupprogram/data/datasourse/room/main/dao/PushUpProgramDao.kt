package com.joesemper.pushupprogram.data.datasourse.room.main.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.Exercise
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.WorkoutDay

@Dao
interface PushUpProgramDao {
    @Query("SELECT * FROM Program")
    suspend fun getAllWorkoutDays(): List<WorkoutDay>

    @Query("SELECT * FROM Exercises")
    suspend fun getAllExercises(): List<Exercise>

    @Insert
    suspend fun insertWorkoutDays(workoutDays: List<WorkoutDay>)

    @Insert
    suspend fun insertExercises(exercises: List<Exercise>)

    @Query("SELECT (SELECT COUNT(*) FROM Program) == 0")
    suspend fun isEmpty(): Boolean

}