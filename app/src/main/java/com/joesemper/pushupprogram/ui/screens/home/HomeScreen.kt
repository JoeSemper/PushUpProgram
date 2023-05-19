package com.joesemper.pushupprogram.ui.screens.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.joesemper.pushupprogram.R
import com.joesemper.pushupprogram.data.datasourse.room.main.entity.DatabaseWorkout
import com.joesemper.pushupprogram.ui.screens.common.DefaultTopAppBar
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    navController: NavController
) {

    val viewModel: HomeViewModel = getViewModel()
    val state = viewModel.homeState

    Scaffold(
        topBar = { DefaultTopAppBar(title = stringResource(id = R.string.app_name)) }
    ) { padding ->
        if (state.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(64.dp),
                    color = MaterialTheme.colors.secondary
                )
            }
        } else {
            AnimatedVisibility(visible = !state.isLoading) {
                LazyColumn(
                    modifier = Modifier.padding(8.dp),
                ) {
                    items(count = state.workouts.size) { columnId ->
                        WorkoutListItem(
                            state = state.workouts[columnId]
                        )

                    }
                }
            }
        }
    }
}