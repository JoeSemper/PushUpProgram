package com.joesemper.pushupprogram.ui.screens.workout

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class WorkoutViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    val workoutId = MutableStateFlow<String>(checkNotNull(savedStateHandle["workoutId"]))
}