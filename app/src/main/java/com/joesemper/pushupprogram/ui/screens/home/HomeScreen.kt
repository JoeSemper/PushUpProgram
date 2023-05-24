package com.joesemper.pushupprogram.ui.screens.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavController
) {

    val viewModel: HomeViewModel = getViewModel()
    val state = viewModel.homeState
    val scrollState = rememberLazyListState()

    Scaffold(
        topBar = {
//            DefaultTopAppBar(title = stringResource(id = R.string.app_name))
            ProgramProgressIndicator(scrollState)
        },
        backgroundColor = MaterialTheme.colors.background
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
                    modifier = Modifier,
                    state = scrollState,
                ) {
                    stickyHeader {
//                        Card(
//                            modifier = Modifier
//                                .padding(16.dp)
//                                .fillMaxWidth()
//                                .wrapContentHeight()
//                                .padding(8.dp)
//                        ) {
//                            Column(
//                                modifier = Modifier.fillMaxWidth(),
//                                verticalArrangement = Arrangement.SpaceEvenly,
//                                horizontalAlignment = Alignment.CenterHorizontally
//                            ) {
//                                Text(text = "Program")
//                                LinearProgressIndicator(
//                                    modifier = Modifier.fillMaxWidth()
//                                )
//                            }
//
//                        }
                    }
                    item {
                        ProgressListItem()
                    }
                    items(count = state.workouts.size) { columnId ->
                        WorkoutListItem(
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .clickable {
                                    navController.navigate(
                                        "workout/${state.workouts[columnId].workoutId}"
                                    )
                                },
                            state = state.workouts[columnId]
                        )

                    }
                }
            }
        }
    }
}