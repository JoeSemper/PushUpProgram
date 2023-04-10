package com.joesemper.pushupprogram.data.repository

import com.joesemper.pushupprogram.data.datasourse.room.main.dao.PushUpProgramDao
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.Exercise
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.WorkoutDay
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.dao.PrepopulatedProgramDao

class ProgramRepository(
    private val prepopulatedProgramDao: PrepopulatedProgramDao,
    private val pushUpProgramDao: PushUpProgramDao
) {
    suspend fun getAll(): List<WorkoutDay> {
        if (pushUpProgramDao.isEmpty()) {

            pushUpProgramDao.insertExercises(prepopulatedProgramDao.getAllExercises().map {
                Exercise(
                    id = it.id,
                    exerciseName = it.exerciseName
                )
            })

            pushUpProgramDao.insertWorkoutDays(prepopulatedProgramDao.getAllWorkoutDays().map {
                WorkoutDay(
                    id = it.id,
                    exerciseOne = it.exerciseOne,
                    exerciseOneRepeats = it.exerciseOneRepeats,
                    exerciseTwo = it.exerciseTwo,
                    exerciseTwoRepeats = it.exerciseTwoRepeats
                )
            })

        }

        return pushUpProgramDao.getAllWorkoutDays()
    }
}