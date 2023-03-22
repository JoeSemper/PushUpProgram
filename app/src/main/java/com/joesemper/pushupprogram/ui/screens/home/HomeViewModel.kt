package com.joesemper.pushupprogram.ui.screens.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel(): ViewModel() {

    val homeState = MutableStateFlow("Push Up")

    fun onClick() {
        homeState.update { value ->
            value + "1"
        }
    }

}