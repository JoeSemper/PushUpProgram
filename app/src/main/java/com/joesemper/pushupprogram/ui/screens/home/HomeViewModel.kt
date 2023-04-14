package com.joesemper.pushupprogram.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joesemper.pushupprogram.domain.entity.Workout
import com.joesemper.pushupprogram.domain.use_case.GetWorkoutProgramUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getWorkoutProgram: GetWorkoutProgramUseCase
) : ViewModel() {

    var homeState by mutableStateOf(HomeScreenState())
        private set

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            getWorkoutProgram().collectLatest { program ->
                homeState = homeState.copy(
                    isLoading = false,
                    workouts = program
                )
            }
        }
    }

}

data class HomeScreenState(
    val isLoading: Boolean = true,
    val workouts: List<Workout> = listOf()
)
