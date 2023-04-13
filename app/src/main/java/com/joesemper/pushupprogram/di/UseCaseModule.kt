package com.joesemper.pushupprogram.di

import com.joesemper.pushupprogram.domain.use_case.GetWorkoutProgramUseCase
import com.joesemper.pushupprogram.domain.use_case.InitiateDatabaseUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory { InitiateDatabaseUseCase(workoutProgramRepository = get()) }
    factory { GetWorkoutProgramUseCase(workoutProgramRepository = get()) }

}