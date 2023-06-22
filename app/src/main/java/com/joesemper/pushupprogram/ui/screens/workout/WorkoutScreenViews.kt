package com.joesemper.pushupprogram.ui.screens.workout

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.joesemper.pushupprogram.ui.theme.GreenColor

@Composable
fun WorkoutScreenTopBar(
    modifier: Modifier = Modifier,
    text: String = "",
    isWorkoutComplete: Boolean
) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.background
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = text,
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.h6
            )

            Icon(
                modifier = Modifier.size(32.dp),
                imageVector = if (isWorkoutComplete) Icons.Default.Done else Icons.Default.Lock,
                tint = GreenColor,
                contentDescription = null
            )
        }

    }
}