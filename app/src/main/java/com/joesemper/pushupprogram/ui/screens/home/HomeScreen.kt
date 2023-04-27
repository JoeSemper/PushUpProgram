package com.joesemper.pushupprogram.ui.screens.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.joesemper.pushupprogram.R
import com.joesemper.pushupprogram.ui.screens.common.DefaultTopAppBar
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    navController: NavController
) {

    val viewModel: HomeViewModel = getViewModel()
    val workouts = viewModel.homeState

    Scaffold(
        backgroundColor = MaterialTheme.colors.primary,
        topBar = { DefaultTopAppBar(title = stringResource(id = R.string.app_name)) }
    ) { padding ->
        if (workouts.isLoading) {
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
            AnimatedVisibility(visible = !workouts.isLoading) {
                LazyColumn(
                    modifier = Modifier.padding(8.dp),
                ) {
                    items(count = 5) {
                        Text(
                            text = "Week 1",
                            style = MaterialTheme.typography.h6,
                        )
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(count = workouts.workouts.size) { id ->
                                Card(
                                    modifier = Modifier
                                        .size(128.dp)
                                        .clickable {
                                            navController.navigate("workout/${workouts.workouts[id].workoutId}")
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
                                            text = workouts.workouts[id].workoutId.toString(),
                                            style = MaterialTheme.typography.body1
                                        )
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Text(
                                            text = workouts.workouts[id].dayInWeek.toString(),
                                            style = MaterialTheme.typography.body1
                                        )
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