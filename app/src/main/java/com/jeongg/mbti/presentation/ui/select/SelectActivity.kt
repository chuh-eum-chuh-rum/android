package com.jeongg.mbti.presentation.ui.select

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.jeongg.mbti.presentation.theme.MbtiTheme
import com.jeongg.mbti.presentation.ui.select.component.TopBar
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalFoundationApi::class)
@AndroidEntryPoint
class SelectActivity : ComponentActivity() {

    private val vm: SelectViewModel by viewModels()

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val state = vm.state.collectAsState().value
            val pagerState = rememberPagerState {
                state.step
            }
            MbtiTheme {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    TopBar(
                        onPrevious = { vm.minusStep() },
                        maxIndex = state.maxStep,
                        currentIndex = state.step.plus(1),
                    )
                    AnimatedContent(
                        targetState = state.step,
                        label = "",
                        transitionSpec = {
                            // Enter: 왼쪽에서 오른쪽으로 등장
                            if (targetState > initialState) {
                                slideInHorizontally { it } + fadeIn() with
                                        slideOutHorizontally { width -> -width } + fadeOut()
                            }
                            // Exit: 오른쪽에서 왼쪽으로 사라짐
                            else {
                                slideInHorizontally { -it } + fadeIn() with
                                        slideOutHorizontally { width -> width } + fadeOut()
                            }
                        },
                    ) { index ->
                        SelectScreen(
                            index = index,
                            state = state,
                            onNextStep = { selectedIndex ->
                                vm.navigateToNextProblem(selectedIndex)
                            }
                        )
                    }
                }
            }
        }
    }
}