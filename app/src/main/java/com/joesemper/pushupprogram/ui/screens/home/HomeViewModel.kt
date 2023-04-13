package com.joesemper.pushupprogram.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.DatabaseWorkout
import com.joesemper.pushupprogram.data.repository.WorkoutProgramRepositoryImpl
import com.joesemper.pushupprogram.domain.entity.Workout
import com.joesemper.pushupprogram.domain.use_case.GetWorkoutProgramUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getWorkoutProgram: GetWorkoutProgramUseCase
) : ViewModel() {

    val homeState = MutableStateFlow(HomeScreenState(listOf()))

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            getWorkoutProgram().collectLatest { program ->
                homeState.update {
                    HomeScreenState(workouts = program)
                }
            }
        }
    }

}

data class HomeScreenState(
    val workouts: List<Workout>
)
