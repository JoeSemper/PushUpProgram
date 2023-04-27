package com.joesemper.pushupprogram.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.joesemper.pushupprogram.R
import com.joesemper.pushupprogram.ui.screens.home.HomeScreen
import com.joesemper.pushupprogram.ui.screens.progress.ProgressScreen
import com.joesemper.pushupprogram.ui.screens.settings.SettingsScreen
import com.joesemper.pushupprogram.ui.screens.workout.WorkoutScreen

const val HOME_ROUTE = "home"
const val PROGRESS_ROUTE = "progress"
const val SETTINGS_ROUTE = "settings"
const val WORKOUT_ROUTE = "workout/{workoutId}"

sealed class Screen(val route: String, @StringRes val labelRes: Int, val icon: ImageVector) {
    object Home : Screen(
        route = HOME_ROUTE,
        labelRes = R.string.home,
        icon = Icons.Default.Home
    )

    object Progress : Screen(
        route = PROGRESS_ROUTE,
        labelRes = R.string.progress,
        icon = Icons.Default.AccountCircle
    )

    object Settings : Screen(
        route = SETTINGS_ROUTE,
        labelRes = R.string.settings,
        icon = Icons.Default.Settings
    )
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = HOME_ROUTE
) {
    val bottomNavItems = listOf(
        Screen.Home,
        Screen.Progress,
        Screen.Settings
    )

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.onPrimary,
                elevation = 4.dp
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                bottomNavItems.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(imageVector = screen.icon, contentDescription = null) },
                        label = { Text(text = stringResource(id = screen.labelRes)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        selectedContentColor = MaterialTheme.colors.secondary,
                        unselectedContentColor = MaterialTheme.colors.onSecondary,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        })
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            modifier = modifier.padding(innerPadding),
            navController = navController,
            startDestination = startDestination
        ) {
            composable(
                route = Screen.Home.route
            ) {
                HomeScreen(navController)
            }

            composable(
                route = Screen.Progress.route
            ) {
                ProgressScreen(navController)
            }

            composable(
                route = Screen.Settings.route
            ) {
                SettingsScreen(navController)
            }

            composable(
                route = WORKOUT_ROUTE,
                arguments = listOf(navArgument("workoutId") { type = NavType.StringType })
            ) {
                WorkoutScreen(navController)
            }

        }
    }
}