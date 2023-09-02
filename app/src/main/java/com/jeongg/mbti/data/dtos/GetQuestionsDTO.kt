package com.jeongg.mbti.data.dtos

import kotlinx.serialization.Serializable

@Serializable
data class GetQuestionsDTO(
    val questions: List<QuestionDTO>
)
