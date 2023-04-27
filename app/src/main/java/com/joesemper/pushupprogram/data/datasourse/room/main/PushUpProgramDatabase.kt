package com.joesemper.pushupprogram.data.datasourse.room.main

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joesemper.pushupprogram.data.datasourse.room.main.dao.WorkoutProgramDao
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.*


@Database(
    entities = [
        DatabaseMuscleGroup::class,
        DatabaseProgram::class,
        DatabaseWorkout::class,
        DatabaseWorkoutSet::class,
        DatabaseWorkoutExercise::class
    ],
    version = 1
)
abstract class PushUpProgramDatabase() : RoomDatabase() {
    abstract fun pushUpProgramDao(): WorkoutProgramDao
}