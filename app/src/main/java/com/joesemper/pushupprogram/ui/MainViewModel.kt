package com.joesemper.pushupprogram.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joesemper.pushupprogram.domain.use_case.GetWorkoutProgramSelectStatusUseCase
import com.joesemper.pushupprogram.domain.use_case.InitiateDatabaseUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import java.util.*


class MainViewModel(
    private val initiateDatabase: InitiateDatabaseUseCase,
    private val getWorkoutProgramSelectStatus: GetWorkoutProgramSelectStatusUseCase
) : ViewModel() {

    var uiState by mutableStateOf(MainUiState())
        private set

    init {
        initDatabase()
        getProgramSelectStatus()
        setIsLoadedUiState()
    }

    private fun initDatabase() {
        viewModelScope.launch {
            initiateDatabase()
        }
    }

    private fun getProgramSelectStatus() {
        viewModelScope.launch {
            getWorkoutProgramSelectStatus().take(1).collect { isSelected ->
                uiState = uiState.copy(isProgramSelected = isSelected)
            }
        }
    }

    private fun setIsLoadedUiState() {
        uiState = uiState.copy(isLoaded = true)
    }
}

data class MainUiState(
    val isLoaded: Boolean = false,
    val isProgramSelected: Boolean = false
)