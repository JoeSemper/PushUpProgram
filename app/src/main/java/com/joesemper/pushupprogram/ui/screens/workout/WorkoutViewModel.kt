package com.joesemper.pushupprogram.ui.screens.workout

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joesemper.pushupprogram.domain.entity.Workout
import com.joesemper.pushupprogram.domain.entity.WorkoutSet
import com.joesemper.pushupprogram.domain.use_case.GetWorkoutByIdUseCase
import com.joesemper.pushupprogram.domain.use_case.GetWorkoutSetsForWorkoutUseCase
import com.joesemper.pushupprogram.domain.use_case.UpdateWorkoutCompleteStatusUseCase
import com.joesemper.pushupprogram.ui.screens.home.HomeScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class WorkoutViewModel(
    savedStateHandle: SavedStateHandle,
    private val getWorkoutById: GetWorkoutByIdUseCase,
    private val updateWorkoutCompleteStatus: UpdateWorkoutCompleteStatusUseCase
) : ViewModel() {
    val workoutId = MutableStateFlow<Int>(checkNotNull(savedStateHandle["workoutId"]))

    var workoutState by mutableStateOf(WorkoutScreenState())
        private set

    init {
        loadWorkoutSets()
    }

    private fun loadWorkoutSets() {
        workoutState = workoutState.copy(isLoading = true)

        viewModelScope.launch {
            getWorkoutById(workoutId.value).collect { workoutSets ->
                workoutState = workoutState.copy(
                    isLoading = false,
                    workout = workoutSets
                )
            }
        }
    }

    fun onCompleteWorkout() {
        viewModelScope.launch {
            updateWorkoutCompleteStatus(
                workoutId = workoutState.workout.workoutId,
                isComplete = true
            )
        }
    }

}

data class WorkoutScreenState(
    val isLoading: Boolean = true,
    val workout: Workout = Workout()

)