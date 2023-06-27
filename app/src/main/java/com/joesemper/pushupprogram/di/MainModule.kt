package com.joesemper.pushupprogram.di

import com.joesemper.pushupprogram.ui.MainViewModel
import com.joesemper.pushupprogram.ui.screens.home.HomeViewModel
import com.joesemper.pushupprogram.ui.screens.select.ProgramSelectViewModel
import com.joesemper.pushupprogram.ui.screens.workout.WorkoutViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel { MainViewModel(get(), get()) }
    viewModel { HomeViewModel(get(), get(), get()) }
    viewModel { WorkoutViewModel(get(), get(), get()) }
    viewModel { ProgramSelectViewModel(get(), get()) }
}