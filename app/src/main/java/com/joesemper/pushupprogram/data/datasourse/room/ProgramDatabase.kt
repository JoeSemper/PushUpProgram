package com.joesemper.pushupprogram.data.datasourse.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joesemper.pushupprogram.data.datasourse.room.dao.ProgramDao
import com.joesemper.pushupprogram.data.datasourse.room.entity.Exercise
import com.joesemper.pushupprogram.data.datasourse.room.entity.WorkoutDay

@Database(entities = [WorkoutDay::class, Exercise::class], version = 1)
abstract class ProgramDatabase(): RoomDatabase() {
    abstract fun programDao(): ProgramDao
}