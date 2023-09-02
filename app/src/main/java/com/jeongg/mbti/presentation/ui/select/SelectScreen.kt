package com.jeongg.mbti.presentation.ui.select

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.jeongg.mbti.data.util.log
import com.jeongg.mbti.presentation.component.LargePrimaryButton
import com.jeongg.mbti.presentation.component.LargePrimaryOutlineButton
import com.jeongg.mbti.presentation.style.MbtiColor
import com.jeongg.mbti.presentation.style.MbtiTitle1
import com.jeongg.mbti.presentation.ui.select.component.TopBar
import com.jeongg.mbti.presentation.ui.util.UiEvent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SelectScreen(
    index: Int,
    state: SelectState,
    onPrevious: () -> Unit,
    onNextStep: (Int) -> Unit,
    viewModel: SelectViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    BackHandler {
        onPrevious()
    }

    if (state.questions.isNotEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(72.dp))
            AsyncImage(
                modifier = Modifier.size(160.dp),
                model = state.questions[state.step].imagePath,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.height(56.dp))
            MbtiTitle1(
                text = state.questions[state.step].question,
                color = MbtiColor.Green1
            )
            Spacer(modifier = Modifier.weight(1f))
            LargePrimaryButton(
                text = state.questions[state.step].answer1.name, enabled = true
            ) {
                onNextStep(1)
            }
            Spacer(modifier = Modifier.height(12.dp))
            LargePrimaryOutlineButton(
                text = state.questions[state.step].answer2.name, enabled = true
            ) {
                onNextStep(2)
            }
            Spacer(modifier = Modifier.height(56.dp))
        }
    }
}