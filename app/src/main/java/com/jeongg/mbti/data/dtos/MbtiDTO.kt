package com.jeongg.mbti.data.dtos

import kotlinx.serialization.Serializable

@Serializable
data class MbtiDTO(
    val mbtiTitle: String,
    val imagePath: String
)
