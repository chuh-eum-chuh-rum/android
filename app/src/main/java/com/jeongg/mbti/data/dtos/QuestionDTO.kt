package com.jeongg.mbti.data.dtos

import kotlinx.serialization.Serializable

@Serializable
data class QuestionDTO(
    val question: String,
    val answer1: String,
    val answer2: String
)
