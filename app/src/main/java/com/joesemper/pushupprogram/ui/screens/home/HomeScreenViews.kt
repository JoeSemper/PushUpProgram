package com.joesemper.pushupprogram.ui.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.joesemper.pushupprogram.domain.entity.WorkoutWithMuscleGroups

@Composable
fun WorkoutListItem(
    modifier: Modifier = Modifier,
    state: WorkoutWithMuscleGroups
) {
    Card(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.background,
        elevation = 4.dp
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 8.dp, vertical = 8.dp),
        ) {
            val (muscleIcons, text, stateIcon) = createRefs()
            val verticalGuideline = createGuidelineFromStart(0.5f)

            Row(
                modifier.constrainAs(muscleIcons) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                },
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                state.muscleGroups.forEach {
                    MuscleGroupIcon(
                        iconRes = it.muscleGroupResId,
                    )
                }
            }

            Text(
                modifier = Modifier.constrainAs(text) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(verticalGuideline)
                    end.linkTo(verticalGuideline)
                },
                text = "Day ${state.dayInProgram}",
                style = MaterialTheme.typography.h6
            )
            Icon(
                modifier = Modifier.size(24.dp).constrainAs(stateIcon){
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
                imageVector = Icons.Default.PlayArrow,
                contentDescription = null
            )

        }
    }
}

@Composable
fun MuscleGroupIcon(
    modifier: Modifier = Modifier,
    iconRes: Int,
) {
    Surface(
        modifier = modifier.size(32.dp),
        color = MaterialTheme.colors.secondary,
        shape = RoundedCornerShape(32.dp),
        border = BorderStroke(width = 0.5.dp, color = MaterialTheme.colors.primary)
    ) {
        Icon(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxSize(),
            painter = painterResource(id = iconRes),
            contentDescription = null
        )
    }
}