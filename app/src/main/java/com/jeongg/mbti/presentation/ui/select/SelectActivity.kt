@file:OptIn(ExperimentalAnimationApi::class)

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.jeongg.mbti.data.util.log
import com.jeongg.mbti.presentation.theme.MbtiTheme
import com.jeongg.mbti.presentation.ui.result.SearchResultActivity
import com.jeongg.mbti.presentation.ui.select.component.TopBar
import com.jeongg.mbti.presentation.ui.util.Extras
import com.jeongg.mbti.presentation.ui.util.UiEvent
import com.jeongg.mbti.presentation.util.finishWithAnimation
import com.jeongg.mbti.presentation.util.rememberToast
import com.jeongg.mbti.presentation.util.startActivityWithAnimation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalFoundationApi::class)
@AndroidEntryPoint
class SelectActivity : ComponentActivity() {

    private val vm: SelectViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val state = vm.state.collectAsState().value
            val toast = rememberToast()

            LaunchedEffect(key1 = vm.eventFlow) {
                vm.eventFlow.collectLatest { event ->
                    when (event) {
                        is UiEvent.SUCCESS -> {
                            "질문 목록 조회 성공 in Screen".log()
                        }

                        is UiEvent.ERROR -> toast.invoke(event.message)

                        is UiEvent.NavigateToResult -> {

                            startActivityWithAnimation<SearchResultActivity>(
                                intentBuilder = {
                                    putExtra(
                                        Extras.ANSWER,
                                        event.answer.joinToString(separator = ",")
                                    )
                                }
                            )
                        }

                        is UiEvent.Finish -> {
                            finishWithAnimation()
                        }

                        else -> {
                            "로딩중".log()
                        }
                    }
                }
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
                            },
                            onPrevious = {
                                vm.minusStep()
                            }
                        )
                    }
                }
            }
        }
    }
}