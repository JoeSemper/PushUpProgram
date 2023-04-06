package com.joesemper.pushupprogram.di

import com.joesemper.pushupprogram.data.repository.ProgramRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { ProgramRepository(get()) }
}