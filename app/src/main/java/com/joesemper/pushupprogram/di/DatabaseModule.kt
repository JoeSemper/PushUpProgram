package com.joesemper.pushupprogram.di

import androidx.room.Room
import com.joesemper.pushupprogram.data.datasourse.room.main.PushUpProgramDatabase
import com.joesemper.pushupprogram.data.datasourse.room.main.dao.WorkoutProgramDao
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.PrepopulatedProgramDatabase
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.dao.PrepopulatedProgramDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single<PushUpProgramDatabase> {
        Room.databaseBuilder(
            androidContext(),
            PushUpProgramDatabase::class.java,
            "PushUpProgram"
        )
            .build()
    }

    single<WorkoutProgramDao> {
        val database = get<PushUpProgramDatabase>()
        database.pushUpProgramDao()
    }


    single<PrepopulatedProgramDatabase> {
        Room.databaseBuilder(
            androidContext(),
            PrepopulatedProgramDatabase::class.java,
            "PrepopulatedProgramDatabase"
        )
            .createFromAsset("database/pushUpProgramDatabase.db")
            .build()
    }

    single<PrepopulatedProgramDao> {
        val prepopulatedDatabase = get<PrepopulatedProgramDatabase>()
        prepopulatedDatabase.prepopulatedProgramDao()
    }
}