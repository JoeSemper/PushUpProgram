package com.joesemper.pushupprogram.di

import androidx.room.Room
import com.joesemper.pushupprogram.data.datasourse.room.ProgramDatabase
import com.joesemper.pushupprogram.data.datasourse.room.dao.ProgramDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<ProgramDatabase> {
        Room.databaseBuilder(androidContext(), ProgramDatabase::class.java, "Program")
            .createFromAsset("database/pushUpProgramDatabase.db")
            .build()
    }

    single<ProgramDao> {
        val database = get<ProgramDatabase>()
        database.programDao()
    }
}