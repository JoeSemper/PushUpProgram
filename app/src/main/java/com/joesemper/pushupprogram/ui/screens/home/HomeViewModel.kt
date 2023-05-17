package com.joesemper.pushupprogram.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joesemper.pushupprogram.domain.entity.Program
import com.joesemper.pushupprogram.domain.entity.Workout
import com.joesemper.pushupprogram.domain.entity.WorkoutSet
import com.joesemper.pushupprogram.domain.use_case.GetWorkoutProgramByIdUseCase
import com.joesemper.pushupprogram.domain.use_case.GetWorkoutSetsForWorkoutUseCase
import com.joesemper.pushupprogram.domain.use_case.GetWorkoutsForProgramUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getWorkoutsForProgramUseCase: GetWorkoutsForProgramUseCase,
    private val getWorkoutProgramByIdUseCase: GetWorkoutProgramByIdUseCase
) : ViewModel() {

    var homeState by mutableStateOf(HomeScreenState())
        private set

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            getWorkoutsForProgramUseCase(programId = 1).collectLatest { program ->
                homeState = homeState.copy(
                    isLoading = false,
                    workouts = program
                )
            }
        }
        viewModelScope.launch {
            getWorkoutProgramByIdUseCase(programId = 1).collectLatest { program ->
                homeState = homeState.copy(
                    isLoading = false,
                    program = program
                )
            }
        }

    }

}

data class HomeScreenState(
    val isLoading: Boolean = true,
    val program: Program = Program(),
    val workouts: List<Workout> = listOf(),
)
