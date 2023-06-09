package com.joesemper.pushupprogram.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joesemper.pushupprogram.domain.entity.WorkoutWithMuscleGroups
import com.joesemper.pushupprogram.domain.use_case.GetCurrentProgramIdUseCase
import com.joesemper.pushupprogram.domain.use_case.GetWorkoutProgramByIdUseCase
import com.joesemper.pushupprogram.domain.use_case.GetWorkoutsForProgramUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getWorkoutsForProgram: GetWorkoutsForProgramUseCase,
    private val getWorkoutProgramById: GetWorkoutProgramByIdUseCase,
    private val getCurrentProgramId: GetCurrentProgramIdUseCase
) : ViewModel() {

    var homeState by mutableStateOf(HomeScreenState())
        private set

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {

            getCurrentProgramId().collect { id ->
                getWorkoutProgramById(programId = id).collectLatest { program ->

                    homeState = homeState.copy(
                        topBarState = homeState.topBarState.copy(title = program.programName)
                    )

                    getWorkoutsForProgram(programId = program.programId).collectLatest { workouts ->
                        homeState = homeState.copy(
                            isLoading = false,
                            workouts = workouts,
                            programProgress = calculateProgress(workouts),
                        )
                    }
                }
            }

        }
    }

    fun onListScroll(hasScrollOffset: Boolean) {
        homeState = homeState.copy(
            topBarState = homeState.topBarState.copy(applyElevation = hasScrollOffset)
        )
    }

    fun onFirstListItemVisibilityChange(isFirstItemVisible: Boolean) {
        homeState = homeState.copy(
            topBarState = homeState.topBarState.copy(reverseColors = isFirstItemVisible)
        )
    }

    private fun calculateProgress(workouts: List<WorkoutWithMuscleGroups>) = ProgramProgress(
        totalWorkouts = workouts.size,
        workoutsDone = workouts.filter { it.isComplete }.size
    )

}

data class HomeScreenState(
    val isLoading: Boolean = true,
    val workouts: List<WorkoutWithMuscleGroups> = listOf(),
    val topBarState: HomeTopBarState = HomeTopBarState(),
    val programProgress: ProgramProgress = ProgramProgress()
)

data class HomeTopBarState(
    val applyElevation: Boolean = false,
    val reverseColors: Boolean = false,
    val title: String = ""
)

data class ProgramProgress(
    val workoutsDone: Int = 0,
    val totalWorkouts: Int = 0
)
