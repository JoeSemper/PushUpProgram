package com.joesemper.pushupprogram.ui.screens.workout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import org.koin.androidx.compose.getViewModel

@Composable
fun WorkoutScreen(navController: NavController) {
    val viewModel: WorkoutViewModel = getViewModel()
    val id = viewModel.workoutId.collectAsState()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = id.value
        )
    }
}