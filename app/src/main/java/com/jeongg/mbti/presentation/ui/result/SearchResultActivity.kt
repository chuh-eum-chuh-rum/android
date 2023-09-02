package com.jeongg.mbti.presentation.ui.result

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchResultActivity : ComponentActivity() {

    private val vm: SearchResultViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val state = vm.state.collectAsState().value

            SearchResultScreen(
                state = state,
                onPrevious = {}
            )
        }
    }
}