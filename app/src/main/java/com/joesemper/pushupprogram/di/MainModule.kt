package com.joesemper.pushupprogram.di

import com.joesemper.pushupprogram.ui.screens.home.HomeViewModel
import com.joesemper.pushupprogram.ui.screens.workout.WorkoutViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { WorkoutViewModel(get()) }
}