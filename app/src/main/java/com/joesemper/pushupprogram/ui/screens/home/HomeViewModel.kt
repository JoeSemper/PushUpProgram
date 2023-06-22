package com.joesemper.pushupprogram.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joesemper.pushupprogram.domain.entity.WorkoutWithMuscleGroups
import com.joesemper.pushupprogram.domain.use_case.GetWorkoutsForProgramUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getWorkoutsForProgramUseCase: GetWorkoutsForProgramUseCase,
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

}

data class HomeScreenState(
    val isLoading: Boolean = true,
    val workouts: List<WorkoutWithMuscleGroups> = listOf(),
    val topBarState: HomeTopBarState = HomeTopBarState()
)

data class HomeTopBarState(
    val applyElevation: Boolean = false,
    val reverseColors: Boolean = false
)
