package com.jeongg.mbti.presentation.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jeongg.mbti.R
import com.jeongg.mbti.presentation.style.MbtiColor

@Composable
fun SplashScreen(){
    Box(
        modifier = Modifier.fillMaxSize().background(MbtiColor.Green1)
    ){
        Image(
            painter = painterResource(R.drawable.ic_3d_fluency_face_with_monocle),
            contentDescription = "logo",
            modifier = Modifier.size(80.dp)
        )
    }
}