package com.joesemper.pushupprogram.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.joesemper.pushupprogram.domain.entity.Workout
import com.joesemper.pushupprogram.domain.entity.WorkoutWithMuscleGroups

@Composable
fun WorkoutListItem(
    modifier: Modifier = Modifier,
    state: WorkoutWithMuscleGroups
) {
    Card(
        modifier = modifier,
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 8.dp, vertical = 8.dp),
        ) {
            state.muscleGroups.forEach {
                IconWithSubtitle(
                    iconRes = it.muscleGroupResId,
                    text = it.muscleGroupName
                )
            }
            Text(
                text = "Day ${state.dayInProgram}",
                style = MaterialTheme.typography.h5
            )
        }
    }
}

@Composable
fun IconWithSubtitle(
    modifier: Modifier = Modifier,
    iconRes: Int,
    text: String? = null
) {
    Column(
        modifier = modifier
            .size(32.dp)
            .background(color = MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = iconRes),
            contentDescription = null
        )
        text?.let {
            Text(
                text = it
            )
        }

    }
}