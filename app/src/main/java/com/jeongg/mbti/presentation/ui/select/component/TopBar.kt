package com.jeongg.mbti.presentation.ui.select.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeongg.mbti.R
import com.jeongg.mbti.presentation.style.MbtiColor
import com.jeongg.mbti.presentation.util.mbtiClickable

@Composable
fun TopBar(
    onPrevious: () -> Unit,
    maxIndex: Int,
    currentIndex: Int,
) {
    val progress = animateFloatAsState(targetValue = currentIndex.toFloat() / maxIndex.toFloat(), label = "")
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Image(
                modifier = Modifier.mbtiClickable {
                    onPrevious()
                },
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null,
            )
            Text(text = "${maxIndex}번째 중 ${currentIndex}번째", modifier = Modifier.align(Alignment.Center))
        }
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            progress = progress.value,
            trackColor = MbtiColor.Gray200,
            color = MbtiColor.Green1,
        )
    }
}

@Preview
@Composable
fun PreviewTopBar() {
    TopBar(onPrevious = {  }, maxIndex = 10, currentIndex = 4)
}