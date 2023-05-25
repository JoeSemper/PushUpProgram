package com.joesemper.pushupprogram.ui.screens.home

import android.os.Parcelable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.joesemper.pushupprogram.ui.screens.common.LoadingView
import kotlinx.parcelize.Parcelize
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    navController: NavController
) {

    val viewModel: HomeViewModel = getViewModel()
    val state = viewModel.homeState
    val scrollState = rememberLazyListState()
    var topBarState by rememberSaveable { mutableStateOf(HomeTopBarState()) }

    LaunchedEffect(scrollState) {
        snapshotFlow { scrollState.firstVisibleItemIndex > 1 }
            .collect {
                topBarState = topBarState.copy(reverseColors = it)
            }
    }

    LaunchedEffect(scrollState) {
        snapshotFlow { scrollState.firstVisibleItemScrollOffset > 0 }
            .collect {
                topBarState = topBarState.copy(applyElevation = it)
            }
    }

    Scaffold(
        topBar = {
            HomeScreenTopBar(
                state = topBarState
            )
        },
        backgroundColor = MaterialTheme.colors.background
    ) { padding ->
        if (state.isLoading) {
            LoadingView()
        } else {
            AnimatedVisibility(visible = !state.isLoading) {
                LazyColumn(
                    modifier = Modifier,
                    state = scrollState,
                ) {

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
