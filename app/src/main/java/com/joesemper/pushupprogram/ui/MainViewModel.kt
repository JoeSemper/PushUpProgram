package com.joesemper.pushupprogram.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joesemper.pushupprogram.domain.use_case.InitiateDatabaseUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val initiateDatabase: InitiateDatabaseUseCase
): ViewModel() {

    init {
        initDatabase()
    }

    private fun initDatabase() {
        viewModelScope.launch {
            initiateDatabase()
        }
    }
}