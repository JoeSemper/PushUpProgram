package com.joesemper.pushupprogram.ui.screens.workout


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.joesemper.pushupprogram.R
import com.joesemper.pushupprogram.ui.screens.common.PagerIndicator
import org.koin.androidx.compose.getViewModel

@Composable
fun WorkoutScreen(navController: NavController) {

    val viewModel: WorkoutViewModel = getViewModel()
    val state = viewModel.workoutState

    AnimatedVisibility(
        visible = !state.isLoading,
        enter = EnterTransition.None
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                WorkoutScreenTopBar(
                    text = stringResource(R.string.workout_day) + " ${state.workout.dayInProgram}"
                )
            }
        ) { paddingValues ->

            WorkoutScreenContent(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = paddingValues.calculateBottomPadding()),
                state = state
            )

        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WorkoutScreenContent(
    modifier: Modifier = Modifier,
    state: WorkoutScreenState
) {
    val pagerState = rememberPagerState()

    Column(
        modifier = modifier
    ) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            pageCount = state.workout.workoutSets.size,
            state = pagerState
        ) { page ->

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = state.workout.workoutSets[page].exercise.exerciseName)
            }

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            PagerIndicator(
                pagesCount = state.workout.workoutSets.count(),
                currentPage = pagerState.currentPage,
            )
        }
    }
}
