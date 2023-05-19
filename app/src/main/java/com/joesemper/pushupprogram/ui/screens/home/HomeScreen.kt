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
        backgroundColor = MaterialTheme.colors.primary,
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
                        Text(
                            text = "Week $columnId",
                            style = MaterialTheme.typography.h6,
                        )
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            if (state.workouts.isNotEmpty()) {
                                items(viewModel.homeState.workouts.toList()) { item ->
                                    Card(
                                        modifier = Modifier
                                            .size(128.dp)
                                            .clickable {
                                                navController.navigate("workout ${item.first.workoutId}")
                                            },
                                        shape = RoundedCornerShape(4.dp),
                                        elevation = 4.dp
                                    ) {
                                        Column(
                                            modifier = Modifier.fillMaxSize(),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(
                                                text = "Day ${item.first.dayInWeek}",
                                                style = MaterialTheme.typography.body1
                                            )
                                            Spacer(modifier = Modifier.height(8.dp))
                                            Text(
                                                text = item.second.first().muscleGroupName,
                                                style = MaterialTheme.typography.body1
                                            )
                                            Text(
                                                text = item.second.last().muscleGroupName,
                                                style = MaterialTheme.typography.body1
                                            )
//                                            Spacer(modifier = Modifier.height(8.dp))
//                                            Text(
//                                                text = state.workouts[id].workoutSets.last().exercise.exerciseName,
//                                                style = MaterialTheme.typography.body1
//                                            )
//                                            Text(
//                                                text = state.workouts[id].workoutSets.last().exercise.muscleGroup.muscleGroupName,
//                                                style = MaterialTheme.typography.body1
//                                            )
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}