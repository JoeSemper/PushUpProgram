package com.joesemper.pushupprogram.data.datasourse.room.prepopulated.dao

import androidx.room.Dao
import androidx.room.Query
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity.PrepopulatedWorkoutExercise
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity.PrepopulatedWorkout

@Dao
interface PrepopulatedProgramDao {

    @Query("SELECT * FROM Program")
    suspend fun getAllWorkoutDays(): List<PrepopulatedWorkout>

    @Query("SELECT * FROM Exercises")
    suspend fun getAllWorkoutExercises(): List<PrepopulatedWorkoutExercise>

}