package com.joesemper.pushupprogram.di

import com.joesemper.pushupprogram.data.datasourse.datastore.SettingsDataStoreImpl
import com.joesemper.pushupprogram.data.repository.WorkoutProgramRepositoryImpl
import com.joesemper.pushupprogram.domain.repository.SettingsDataStore
import com.joesemper.pushupprogram.domain.repository.WorkoutProgramRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single<WorkoutProgramRepository> { WorkoutProgramRepositoryImpl(get()) }
    single<SettingsDataStore> { SettingsDataStoreImpl(androidContext()) }
}