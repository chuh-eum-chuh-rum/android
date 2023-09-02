package com.jeongg.mbti.presentation.ui.result

import com.jeongg.mbti.presentation.util.randomString

data class SearchResultState(
    val title: String = randomString(5),
    val imageRes: String = "",
    val description: String = randomString(60),
    val likeTitle: String = randomString(5),
    val likeImageRes: String = "",
    val likeDescription: String = randomString(60),
    val dislikeTitle: String = randomString(5),
    val dislikeImageRes: String = "",
    val dislikeDescription: String = randomString(60),
)