package com.jeongg.mbti.data.dtos

import kotlinx.serialization.Serializable

@Serializable
data class PostAnswerRequestDTO(
    val answers: List<Int>
)
