package com.joesemper.pushupprogram

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.joesemper.pushupprogram.ui.screens.home.HomeScreen
import com.joesemper.pushupprogram.ui.screens.workout.WorkoutScreen

const val HOME_ROUTE = "home"
const val WORKOUT_ROUTE = "workout/{workoutId}"

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = HOME_ROUTE
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            route = HOME_ROUTE
        ) {
            HomeScreen(navController)
        }

        composable(
            route = WORKOUT_ROUTE,
            arguments = listOf(navArgument("workoutId") { type = NavType.StringType})
        ) {
            WorkoutScreen(navController)
        }

    }
}