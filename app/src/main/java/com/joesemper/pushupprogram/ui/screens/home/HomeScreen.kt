package com.joesemper.pushupprogram.ui.screens.home

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen() {

    val viewModel: HomeViewModel = getViewModel()
    val value = viewModel.homeState.collectAsState()

    Scaffold(
        backgroundColor = MaterialTheme.colors.primary
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(8.dp),
        ) {
            items(count = 5) {
                Text(
                    text = "Week 1",
                    style = MaterialTheme.typography.h6,
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(count = 7) {
                        Card(
                            modifier = Modifier.size(128.dp),
                            shape = RoundedCornerShape(4.dp),
                            elevation = 4.dp
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Day 1",
                                    style = MaterialTheme.typography.h6
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "Triceps",
                                    style = MaterialTheme.typography.body1
                                )
                                Text(
                                    text = "Back",
                                    style = MaterialTheme.typography.body1
                                )
                            }
                        }
                    }

                }
            }
        }
    }
}