package com.joesemper.pushupprogram.ui.screens.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen() {

    val viewModel: HomeViewModel = getViewModel()
    val value = viewModel.homeState.collectAsState()

    Scaffold() {
        LazyColumn {
            items(count = 10) {
                TextButton(onClick = { viewModel.onClick() }) {
                    Text(text = value.value)
                }
            }
        }
    }
}