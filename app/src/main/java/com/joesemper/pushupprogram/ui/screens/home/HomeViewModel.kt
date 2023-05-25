package com.joesemper.pushupprogram.ui.screens.home

import android.os.Parcelable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.DatabaseMuscleGroup
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.DatabaseWorkout
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.DatabaseWorkoutWithMuscleGroups
import com.joesemper.pushupprogram.domain.entity.*
import com.joesemper.pushupprogram.domain.use_case.GetWorkoutProgramByIdUseCase
import com.joesemper.pushupprogram.domain.use_case.GetWorkoutSetsForWorkoutUseCase
import com.joesemper.pushupprogram.domain.use_case.GetWorkoutsForProgramUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.parcelize.Parcelize

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

    fun onListScroll(isScrolled: Boolean) {

    }

    fun onFirstListItemVisibilityChange(isFirstItemVisible: Boolean) {

    }

}

data class HomeScreenState(
    val isLoading: Boolean = true,
    val workouts: List<WorkoutWithMuscleGroups> = listOf(),
    val topBarState: HomeTopBarState = HomeTopBarState()
)

@Parcelize
data class HomeTopBarState(
    val applyElevation: Boolean = false,
    val reverseColors: Boolean = false
): Parcelable
