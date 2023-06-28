package com.joesemper.pushupprogram.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.joesemper.pushupprogram.ui.theme.PushUpProgramTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: MainViewModel = getViewModel()

        installSplashScreen().apply {
            setKeepOnScreenCondition { !viewModel.uiState.isLoaded }
        }

        setContent {
            PushUpProgramTheme {
                AppNavHost(isProgramSelected = viewModel.uiState.isProgramSelected)
            }
        }

    }

}
