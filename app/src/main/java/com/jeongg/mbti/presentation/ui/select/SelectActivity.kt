package com.jeongg.mbti.presentation.ui.select

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.collectAsState
import com.jeongg.mbti.presentation.theme.MbtiTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalFoundationApi::class)
@AndroidEntryPoint
class SelectActivity : ComponentActivity() {

    private val vm: SelectViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val state = vm.state.collectAsState().value
            val pagerState = rememberPagerState {
                state.step
            }
            MbtiTheme {
//                HorizontalPager(state = pagerState) {
                    SelectScreen(
                        state = state,
                        onPrevious = {
                            vm.minusStep()
                        },
                        onNextStep = { selectedIndex ->
                            vm.navigateToNextProblem(selectedIndex)
                        }
                    )
                }
//            }
        }
    }
}