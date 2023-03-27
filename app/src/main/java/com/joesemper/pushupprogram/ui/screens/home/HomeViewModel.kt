package com.joesemper.pushupprogram.ui.screens.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import java.util.*

class HomeViewModel() : ViewModel() {

    val homeState = MutableStateFlow(HomeScreenState(listOf()))

    init {
        homeState.update {
            val workouts = mutableListOf<Workout>()

            repeat(7) { workouts.add(Workout()) }

            HomeScreenState(workouts)
        }
    }

}

data class HomeScreenState(
    val workouts: List<Workout>
)

data class Workout(
    val id: String = UUID.randomUUID().toString()
)