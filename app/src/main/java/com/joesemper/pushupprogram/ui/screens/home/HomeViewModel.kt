package com.joesemper.pushupprogram.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.WorkoutDay
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity.WorkoutDayWithExercise
import com.joesemper.pushupprogram.data.repository.ProgramRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: ProgramRepository
) : ViewModel() {

    val homeState = MutableStateFlow(HomeScreenState(listOf()))

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            homeState.update {
               HomeScreenState(workouts = repository.getAll())
            }
        }
    }

}

data class HomeScreenState(
    val workouts: List<WorkoutDay>
)
