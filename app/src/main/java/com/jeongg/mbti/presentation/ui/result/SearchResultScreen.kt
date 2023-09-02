@file:OptIn(ExperimentalMaterial3Api::class)

package com.jeongg.mbti.presentation.ui.result

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jeongg.mbti.presentation.component.LargePrimaryButton
import com.jeongg.mbti.presentation.component.LargePrimaryOutlineButton
import com.jeongg.mbti.presentation.style.MbtiBody1
import com.jeongg.mbti.presentation.style.MbtiBody3
import com.jeongg.mbti.presentation.style.MbtiBody7
import com.jeongg.mbti.presentation.style.MbtiBody9
import com.jeongg.mbti.presentation.style.MbtiColor
import com.jeongg.mbti.presentation.style.MbtiTitle1
import com.jeongg.mbti.presentation.ui.select.component.BackPressedTopBar

@Composable
fun SearchResultScreen(
    state: SearchResultState,
    onPrevious: () -> Unit
) {
    Scaffold(
        topBar = {
            BackPressedTopBar {
                onPrevious()
            }
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .background(color = Color.White)
                    .padding(all = 16.dp)
            ) {
                LargePrimaryButton(text = "이미지 저장하기", enabled = true) {

                }
                Spacer(modifier = Modifier.height(8.dp))
                LargePrimaryOutlineButton(text = "공유하기", enabled = true) {

                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            MbtiBody1(text = "당신은", color = MbtiColor.Black)
            MbtiTitle1(text = "글램퍼 유형", color = MbtiColor.Green1)
            MbtiBody1(text = "이에요!", color = MbtiColor.Black)
            Spacer(modifier = Modifier.height(32.dp))
            AsyncImage(
                modifier = Modifier.size(160.dp),
                model = state.imageRes,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        color = MbtiColor.Gray200
                    )
                    .padding(all = 16.dp)
            ) {
                MbtiBody7(
                    text = state.description,
                    color = MbtiColor.Gray800,
                    align = TextAlign.Center,
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Divider()
            Spacer(modifier = Modifier.height(24.dp))
            RelationMbti(
                type = "같이 바캉스 가면 좋은 유형",
                title = state.likeTitle,
                imageRes = state.likeImageRes,
                description = state.likeDescription,
            )
            Spacer(modifier = Modifier.height(24.dp))
            RelationMbti(
                type = "같이 바캉스 가면 안 맞을 수 있는 유형",
                title = state.dislikeTitle,
                imageRes = state.dislikeImageRes,
                description = state.dislikeDescription,
                titleColor = MbtiColor.Error,
            )
        }
    }
}

@Composable
fun RelationMbti(
    type: String,
    title: String,
    imageRes: String,
    description: String,
    titleColor: Color = MbtiColor.Green1,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MbtiBody3(text = type, color = titleColor)
        Spacer(modifier = Modifier.height(16.dp))
        AsyncImage(
            modifier = Modifier.size(80.dp),
            model = imageRes,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(color = MbtiColor.Gray200)
                .padding(all = 16.dp),
        ) {
            MbtiBody7(text = title)
            Spacer(modifier = Modifier.height(4.dp))
            MbtiBody9(
                text = description,
                align = TextAlign.Center
            )
        }
    }
}