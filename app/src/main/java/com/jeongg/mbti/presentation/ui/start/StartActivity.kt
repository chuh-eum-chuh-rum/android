package com.jeongg.mbti.presentation.ui.start

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jeongg.mbti.presentation.ui.select.SelectActivity
import com.jeongg.mbti.presentation.util.startActivityWithAnimation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StartScreen {
                navigateToSelect()
            }
        }
    }

    private fun navigateToSelect() {
        startActivityWithAnimation<SelectActivity>()
    }
}