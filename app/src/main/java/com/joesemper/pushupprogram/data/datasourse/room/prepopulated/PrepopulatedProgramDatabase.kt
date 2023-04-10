package com.joesemper.pushupprogram.data.datasourse.room.prepopulated

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.dao.PrepopulatedProgramDao
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity.PrepopulatedExercise
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity.PrepopulatedWorkoutDay

@Database(entities = [PrepopulatedWorkoutDay::class, PrepopulatedExercise::class], version = 1)
abstract class PrepopulatedProgramDatabase(): RoomDatabase() {
    abstract fun prepopulatedProgramDao(): PrepopulatedProgramDao
}