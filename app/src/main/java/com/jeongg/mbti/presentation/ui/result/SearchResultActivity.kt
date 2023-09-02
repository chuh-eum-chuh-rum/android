package com.jeongg.mbti.presentation.ui.result

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.jeongg.mbti.data.util.log
import com.jeongg.mbti.presentation.ui.start.StartActivity
import com.jeongg.mbti.presentation.ui.util.UiEvent
import com.jeongg.mbti.presentation.util.changeActivityWithAnimation
import com.jeongg.mbti.presentation.util.rememberToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class SearchResultActivity : ComponentActivity() {

    private val vm: SearchResultViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val state = vm.state.collectAsState().value
            val toast = rememberToast()

            LaunchedEffect(key1 = vm.eventFlow) {
                vm.eventFlow.collectLatest { event ->
                    when (event) {
                        is UiEvent.SUCCESS -> { "결과 조회 성공 in Screen".log() }
                        is UiEvent.ERROR -> toast.invoke(event.message)
                        else -> { "로딩중".log() }
                    }
                }
            }
            SearchResultScreen(
                state = state,
                onPrevious = {},
                onRetry = {
                    changeActivityWithAnimation<StartActivity>()
                }
            )
        }
    }
}