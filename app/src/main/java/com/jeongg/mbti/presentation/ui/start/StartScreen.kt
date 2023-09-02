package com.jeongg.mbti.presentation.ui.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeongg.mbti.R
import com.jeongg.mbti.presentation.component.LargePrimaryButton
import com.jeongg.mbti.presentation.style.MbtiColor
import com.jeongg.mbti.presentation.style.MbtiTextStyle

@Composable
fun StartScreen(
    navigateToSelect: () -> Unit,
){
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "내 얼레벌레 바캉스 유형을 알아보자!",
            style = MbtiTextStyle.Body1,
            color = MbtiColor.Green1
        )
        Spacer(modifier = Modifier.height(24.dp))
        Image(
            painter = painterResource(R.drawable.ic_3d_fluency_face_with_monocle),
            contentDescription = "내 얼레벌레 바캉스 유형을 알아보자!",
            modifier = Modifier.size(102.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        LargePrimaryButton(
            text = "바캉스 유형 알아보러 가기",
            enabled = true
        ) {
            navigateToSelect()
        }
    }
}