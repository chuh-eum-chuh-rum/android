package com.jeongg.mbti.data.dtos

import kotlinx.serialization.Serializable

@Serializable
data class PostAnswerResponseDTO(
    val mbtiTitle: String,
    val mbtiContents: String,
    val toBoldContent: String,
    val imagePath: String,
    val goodMbti: MbtiDTO,
    val badMBTI: MbtiDTO
)
