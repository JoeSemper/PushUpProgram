package com.joesemper.pushupprogram.ui.screens.home

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                    RoundedIcon(
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
                modifier = Modifier
                    .size(24.dp)
                    .constrainAs(stateIcon) {
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
fun WorkoutListItem2(
    modifier: Modifier = Modifier,
    state: WorkoutWithMuscleGroups
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colors.background,
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
        ) {
            val (muscleIcons, text, stateIcon, divider) = createRefs()
            val verticalGuideline = createGuidelineFromStart(0.5f)

            Text(
                modifier = Modifier.constrainAs(text) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(verticalGuideline)
                    end.linkTo(verticalGuideline)
                },
                text = "${state.dayInProgram}",
                style = MaterialTheme.typography.h6
            )

            Row(
                modifier.constrainAs(muscleIcons) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                },
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                state.muscleGroups.forEach {
                    RoundedIcon(
                        iconRes = it.muscleGroupResId,
                    )
                }
            }



            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .constrainAs(stateIcon) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    },
                imageVector = Icons.Default.PlayArrow,
                contentDescription = null
            )

            Divider(
                modifier = Modifier.constrainAs(divider) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start, 64.dp)
                }
            )

        }
    }
}


@Composable
fun ProgressListItem(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f),
                color = MaterialTheme.colors.primary
            ) {
            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f),
                color = MaterialTheme.colors.background
            ) {
            }
        }
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Push up beginner")
                LinearProgressIndicator(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    progress = 0.7f
                )
            }
        }
    }

}

@Composable
fun HomeScreenTopBar(
    modifier: Modifier = Modifier,
    state: HomeTopBarState
) {

    val backgroundColor = animateColorAsState(
        targetValue = if (state.reverseColors) {
            MaterialTheme.colors.background
        } else {
            MaterialTheme.colors.primary
        }
    )

    val contentColor = animateColorAsState(
        targetValue = if (state.reverseColors) {
            MaterialTheme.colors.onBackground
        } else {
            MaterialTheme.colors.onPrimary
        }
    )

    val elevation = animateDpAsState(
        targetValue = if (state.applyElevation) 8.dp else 0.dp
    )

    TopAppBar(
        modifier = modifier,
        elevation = elevation.value,
        backgroundColor = backgroundColor.value,
        contentColor = contentColor.value
    ) {

        Column(
            modifier = Modifier.fillMaxWidth()
        )
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Push up program",
                    style = MaterialTheme.typography.h6
                )
                IconButton(
                    modifier = Modifier.size(32.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        imageVector = Icons.Default.List,
                        contentDescription = null
                    )
                }
            }
        }

    }
}

@Composable
fun RoundedIcon(
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