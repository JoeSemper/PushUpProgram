package com.joesemper.pushupprogram.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.joesemper.pushupprogram.ui.PROGRAM_SELECT_ROUTE
import com.joesemper.pushupprogram.ui.screens.common.LoadingView
import org.koin.androidx.compose.getViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController
) {

    val viewModel: HomeViewModel = getViewModel()
    val state = viewModel.homeState
    val scrollState = rememberLazyListState()

    LaunchedEffect(scrollState) {
        snapshotFlow { scrollState.firstVisibleItemIndex > 0 }
            .collect {
                viewModel.onFirstListItemVisibilityChange(it)
            }
    }

    LaunchedEffect(scrollState) {
        snapshotFlow { scrollState.firstVisibleItemScrollOffset > 0 }
            .collect {
                viewModel.onListScroll(it)
            }
    }

    Scaffold(
        topBar = {
            HomeScreenTopBar(
                state = viewModel.homeState.topBarState,
                onIconClick = { navController.navigate(PROGRAM_SELECT_ROUTE) }
            )
        },
        backgroundColor = MaterialTheme.colors.background
    ) {

        if (state.isLoading) {

            LoadingView(modifier = Modifier.fillMaxSize())

        } else {

            HomeScreenContent(
                state = state,
                scrollState = scrollState,
                onWorkoutItemClick = { navController.navigate("workout/${it}") }
            )

        }
    }
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    state: HomeScreenState,
    scrollState: LazyListState,
    onWorkoutItemClick: (Int) -> Unit
) {
    AnimatedVisibility(visible = !state.isLoading) {

        LazyColumn(
            modifier = modifier,
            state = scrollState,
        ) {

            item {
                ProgressListItem(progress = state.programProgress)
            }

            items(count = state.workouts.size) { columnId ->
                WorkoutListItem(
                    modifier = Modifier
                        .clickable { onWorkoutItemClick(state.workouts[columnId].workoutId) },
                    state = state.workouts[columnId]
                )
            }

        }

    }
}
