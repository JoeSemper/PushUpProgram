package com.joesemper.pushupprogram.ui.screens.home

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.joesemper.pushupprogram.domain.entity.WorkoutWithMuscleGroups
import com.joesemper.pushupprogram.ui.theme.GreenColor
import com.joesemper.pushupprogram.ui.theme.SecondaryTextColor

@Composable
fun WorkoutListItem(
    modifier: Modifier = Modifier,
    state: WorkoutWithMuscleGroups
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colors.background,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier.size(64.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "${state.dayInProgram}",
                        style = MaterialTheme.typography.h6,
                        color = SecondaryTextColor
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "21.06.2032",
                        style = MaterialTheme.typography.body1
                    )

                    Row() {
                        state.muscleGroups.forEach {
                            RoundedIcon(
                                modifier = Modifier.padding(horizontal = 4.dp),
                                iconRes = it.muscleGroupResId,
                            )
                        }
                    }

                }

                Icon(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .size(32.dp),
                    imageVector = Icons.Default.Done,
                    contentDescription = null,
                    tint = GreenColor
                )

            }

            Divider(modifier = Modifier
                .padding(start = 64.dp)
                .fillMaxWidth())
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
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
                    style = MaterialTheme.typography.h6,
                    color = contentColor.value
                )

                IconButton(
                    modifier = Modifier.size(32.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        imageVector = Icons.Default.List,
                        contentDescription = null,
                        tint = contentColor.value
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