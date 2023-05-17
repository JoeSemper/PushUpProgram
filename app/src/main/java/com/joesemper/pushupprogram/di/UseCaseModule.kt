package com.joesemper.pushupprogram.di

import com.joesemper.pushupprogram.domain.use_case.*
import org.koin.dsl.module

val useCaseModule = module {

    factory { InitiateDatabaseUseCase(workoutProgramRepository = get()) }
    factory { GetAllWorkoutProgramsUseCase(workoutProgramRepository = get()) }
    factory { GetWorkoutSetsForWorkoutUseCase(workoutProgramRepository = get()) }
    factory { GetWorkoutsForProgramUseCase(workoutProgramRepository = get()) }
    factory { GetWorkoutProgramByIdUseCase(workoutProgramRepository = get()) }

}