package com.joesemper.pushupprogram.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    navController: NavController
) {

    val viewModel: HomeViewModel = getViewModel()
    val workouts = viewModel.homeState.collectAsState()

    Scaffold(
        backgroundColor = MaterialTheme.colors.primary
    ) { padding ->
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
                    items(count = workouts.value.workouts.size) { id ->
                        Card(
                            modifier = Modifier
                                .size(128.dp)
                                .clickable {
                                    navController.navigate("workout/${workouts.value.workouts[id].id}")
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
                                    text = workouts.value.workouts[id].id.toString(),
                                    style = MaterialTheme.typography.body1
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = workouts.value.workouts[id].exerciseOne.toString(),
                                    style = MaterialTheme.typography.body1
                                )
//                                Text(
//                                    text = workouts.value.workouts[id].exerciseTwo.exerciseName,
//                                    style = MaterialTheme.typography.body1
//                                )
                            }
                        }
                    }

                }
            }
        }
    }
}