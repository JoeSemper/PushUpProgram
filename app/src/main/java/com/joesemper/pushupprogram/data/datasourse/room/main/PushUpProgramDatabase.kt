package com.joesemper.pushupprogram.data.datasourse.room.main

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joesemper.pushupprogram.data.datasourse.room.main.dao.PushUpProgramDao
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.Exercise
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.WorkoutDay


@Database(entities = [WorkoutDay::class, Exercise::class], version = 1)
abstract class PushUpProgramDatabase() : RoomDatabase() {
    abstract fun pushUpProgramDao(): PushUpProgramDao
}