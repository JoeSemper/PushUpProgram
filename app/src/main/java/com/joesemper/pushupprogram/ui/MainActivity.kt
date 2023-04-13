package com.joesemper.pushupprogram.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.joesemper.pushupprogram.ui.theme.PushUpProgramTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: MainViewModel = getViewModel()

        setContent {
            PushUpProgramTheme {
                AppNavHost()
            }
        }

    }

}
