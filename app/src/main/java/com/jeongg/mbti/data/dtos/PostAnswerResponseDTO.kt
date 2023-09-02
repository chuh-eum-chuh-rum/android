package com.jeongg.mbti.data.dtos

import kotlinx.serialization.Serializable

@Serializable
data class PostAnswerResponseDTO(
    val mbtiTitle: String,
    val mbtiContents: String,
    val toBoldContent: List<String>,
    val imagePath: String,
    val goodMbti: MbtiDTO,
    val badMbti: MbtiDTO
)
