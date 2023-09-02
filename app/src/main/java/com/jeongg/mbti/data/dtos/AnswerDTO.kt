package com.jeongg.mbti.data.dtos

import kotlinx.serialization.Serializable

@Serializable
data class AnswerDTO(
    val name: String,
    val mbtiType: String
)
