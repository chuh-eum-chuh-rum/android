@file:OptIn(ExperimentalMaterial3Api::class)

package com.jeongg.mbti.presentation.ui.result

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.jeongg.mbti.presentation.component.LargePrimaryButton
import com.jeongg.mbti.presentation.component.LargePrimaryOutlineButton
import com.jeongg.mbti.presentation.style.MbtiBody1
import com.jeongg.mbti.presentation.style.MbtiBody3
import com.jeongg.mbti.presentation.style.MbtiBody7
import com.jeongg.mbti.presentation.style.MbtiBody9
import com.jeongg.mbti.presentation.style.MbtiColor
import com.jeongg.mbti.presentation.style.MbtiTitle1
import com.jeongg.mbti.presentation.ui.select.component.BackPressedTopBar
import com.jeongg.mbti.presentation.ui.util.FileUtil
import com.jeongg.mbti.presentation.ui.util.ShareUtil
import com.jeongg.mbti.presentation.util.rememberToast

@Composable
fun SearchResultScreen(
    state: SearchResultState,
    onPrevious: () -> Unit,
    onRetry: () -> Unit,
) {
    val context = LocalContext.current
    val imageLoader =
        ImageLoader.Builder(context).allowHardware(false) // Disallow hardware bitmaps.
            .build()

    val imagePainter = rememberAsyncImagePainter(
        model = state.imageRes,
        imageLoader = imageLoader,
    )

    val likeImagePainter = rememberAsyncImagePainter(
        model = state.likeImageRes,
        imageLoader = imageLoader,
    )

    val disLikeImagePainter = rememberAsyncImagePainter(
        model = state.dislikeImageRes,
        imageLoader = imageLoader,
    )

    val snapShot = ComposeToBitmap {
        ShareResultImage(
            title = state.title,
            imagePainter = imagePainter,
            description = state.description,
            likeImagePainter = likeImagePainter,
            dislikeImagePainter = disLikeImagePainter,
            likeTitle = state.likeTitle,
            dislikeTitle = state.dislikeTitle,
        )
    }

    val toast = rememberToast()

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
                    val bitmap = snapShot.invoke()
                    saveImageInGallery(bitmap, context, "바캉스 성적표")
                    toast.invoke("성적표를 저장했습니다!")
                }
                Spacer(modifier = Modifier.height(8.dp))
                LargePrimaryOutlineButton(text = "공유하기", enabled = true) {
                    val bitmap = snapShot.invoke()
                    val file = FileUtil.imageExternalSave(bitmap)
                    kotlin.runCatching {
                        ShareUtil.shareInstagram(
                            context = context,
                            path = file,
                        )
                    }.onFailure {
                        toast.invoke("인스타 공유하기에 실패했습니다! ${it.message}")
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                LargePrimaryOutlineButton(text = "다시하기", enabled = true) {
                    onRetry()
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
            MbtiTitle1(text = state.title, color = MbtiColor.Green1)
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
                    .padding(horizontal = 16.dp)
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
                modifier = Modifier.padding(horizontal = 16.dp),
                type = "같이 바캉스 가면 좋은 유형",
                title = state.likeTitle,
                imageRes = likeImagePainter,
                description = state.likeDescription,
            )
            Spacer(modifier = Modifier.height(24.dp))
            RelationMbti(
                modifier = Modifier.padding(horizontal = 16.dp),
                type = "같이 바캉스 가면 안 맞을 수 있는 유형",
                title = state.dislikeTitle,
                imageRes = disLikeImagePainter,
                description = state.dislikeDescription,
                titleColor = MbtiColor.Error,
            )
        }
    }
}

@Composable
fun ShareResultImage(
    title: String,
    imagePainter: Painter,
    description: String,
    likeImagePainter: Painter,
    likeTitle: String,
    dislikeImagePainter: Painter,
    dislikeTitle: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp),
            )
            .padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        MbtiBody1(text = "당신은", color = MbtiColor.Black)
        MbtiTitle1(text = "$title 유형", color = MbtiColor.Green1)
        MbtiBody1(text = "이에요!", color = MbtiColor.Black)
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            modifier = Modifier.size(160.dp),
            painter = imagePainter,
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
                .padding(all = 16.dp),
            contentAlignment = Alignment.Center,
        ) {
            MbtiBody7(
                modifier = Modifier.fillMaxWidth(),
                text = description,
                color = MbtiColor.Gray800,
                align = TextAlign.Center,
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    modifier = Modifier.size(80.dp),
                    painter = likeImagePainter,
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.height(16.dp))
                MbtiBody7(text = "같이 바캉스 고?")
                MbtiBody7(text = likeTitle, color = MbtiColor.Green1)
            }
            Spacer(modifier = Modifier.width(56.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    modifier = Modifier.size(80.dp),
                    painter = dislikeImagePainter,
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.height(16.dp))
                MbtiBody7(text = "너랑은 여행 안 가!!")
                MbtiBody7(text = dislikeTitle, color = MbtiColor.Green1)
            }
        }
        Spacer(modifier = Modifier.height(54.dp))
    }
}

@Composable
fun RelationMbti(
    modifier: Modifier = Modifier,
    type: String,
    title: String,
    imageRes: Painter,
    description: String,
    titleColor: Color = MbtiColor.Green1,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MbtiTitle1(text = type, color = titleColor)
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            modifier = Modifier.size(80.dp),
            painter = imageRes,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(16.dp))
        MbtiBody3(text = title, color = MbtiColor.Black)
    }
}