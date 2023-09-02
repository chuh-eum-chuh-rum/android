package com.jeongg.mbti.presentation.ui.select

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jeongg.mbti.presentation.component.LargePrimaryButton
import com.jeongg.mbti.presentation.component.LargePrimaryOutlineButton
import com.jeongg.mbti.presentation.style.MbtiColor
import com.jeongg.mbti.presentation.style.MbtiTitle1
import com.jeongg.mbti.presentation.ui.select.component.TopBar

@Composable
fun SelectScreen(
    index: Int,
    state: SelectState,
    onNextStep: (Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(72.dp))
        AsyncImage(
            modifier = Modifier.size(160.dp),
            model = "https://em-content.zobj.net/source/microsoft-teams/363/olive_1fad2.png",
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(56.dp))
        MbtiTitle1(
            text = "이건 질문 영역입니다",
            color = MbtiColor.Green1
        )
        Spacer(modifier = Modifier.weight(1f))
        LargePrimaryButton(text = "안뇽안뇽안뇽안뇽안뇽안뇽", enabled = true) {
            onNextStep(1)
        }
        Spacer(modifier = Modifier.height(12.dp))
        LargePrimaryOutlineButton(text = "안뇽안뇽안뇽안뇽안뇽안뇽", enabled = true) {
            onNextStep(2)
        }
        Spacer(modifier = Modifier.height(56.dp))
    }
}