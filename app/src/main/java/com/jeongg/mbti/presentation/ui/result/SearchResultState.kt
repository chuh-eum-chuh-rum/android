package com.jeongg.mbti.presentation.ui.result

import com.jeongg.mbti.presentation.util.randomString

data class SearchResultState(
    val title: String = randomString(5),
    val imageRes: String = "https://em-content.zobj.net/source/microsoft-teams/363/olive_1fad2.png",
    val description: String = randomString(60),
    val likeTitle: String = randomString(5),
    val likeImageRes: String = "https://em-content.zobj.net/source/microsoft-teams/363/olive_1fad2.png",
    val likeDescription: String = randomString(60),
    val dislikeTitle: String = randomString(5),
    val dislikeImageRes: String = "https://em-content.zobj.net/source/microsoft-teams/363/olive_1fad2.png",
    val dislikeDescription: String = randomString(60),
)