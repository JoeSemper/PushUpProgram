package com.joesemper.pushupprogram.data.datasourse.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.joesemper.pushupprogram.data.datasourse.room.entity.WorkoutDay

@Dao
interface ProgramDao {
    @Query("SELECT * FROM Program")
    suspend fun getAll(): List<WorkoutDay>
}