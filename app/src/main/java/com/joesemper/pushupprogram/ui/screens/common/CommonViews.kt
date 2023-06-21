package com.joesemper.pushupprogram.ui.screens.common

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.joesemper.pushupprogram.ui.theme.GreenColor

@Composable
fun DefaultTopAppBar(
    modifier: Modifier = Modifier,
    title: String = ""
) {

    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.background,
        elevation = 4.dp
    ) {
        Text(
            text = title,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h6
        )
    }
}

@Composable
fun LoadingView(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(64.dp),
            color = MaterialTheme.colors.primary
        )
    }
}

@Composable
fun PagerIndicator(
    modifier: Modifier = Modifier,
    pagesCount: Int,
    currentPage: Int
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagesCount) { iteration ->
            val color =
                animateColorAsState(
                    targetValue = when {
                        (currentPage == iteration) -> MaterialTheme.colors.secondaryVariant
                        (currentPage > iteration) -> GreenColor
                        else -> MaterialTheme.colors.secondary
                    }
                )

            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color.value)
                    .size(8.dp)

            )
        }
    }
}

