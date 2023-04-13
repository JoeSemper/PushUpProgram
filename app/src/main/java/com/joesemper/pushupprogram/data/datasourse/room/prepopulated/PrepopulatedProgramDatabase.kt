package com.joesemper.pushupprogram.data.datasourse.room.prepopulated

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.dao.PrepopulatedProgramDao
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity.PrepopulatedWorkoutExercise
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity.PrepopulatedWorkout

@Database(entities = [PrepopulatedWorkout::class, PrepopulatedWorkoutExercise::class], version = 1)
abstract class PrepopulatedProgramDatabase(): RoomDatabase() {
    abstract fun prepopulatedProgramDao(): PrepopulatedProgramDao
}