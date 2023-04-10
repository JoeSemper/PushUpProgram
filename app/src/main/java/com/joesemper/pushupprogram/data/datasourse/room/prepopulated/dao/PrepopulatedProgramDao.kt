package com.joesemper.pushupprogram.data.datasourse.room.prepopulated.dao

import androidx.room.Dao
import androidx.room.Query
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.Exercise
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.WorkoutDay
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity.PrepopulatedExercise
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity.PrepopulatedWorkoutDay
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity.WorkoutDayWithExercise

@Dao
interface PrepopulatedProgramDao {

    @Query("SELECT * FROM Program")
    suspend fun getAllWorkoutDays(): List<PrepopulatedWorkoutDay>

    @Query("SELECT * FROM Exercises")
    suspend fun getAllExercises(): List<PrepopulatedExercise>

}