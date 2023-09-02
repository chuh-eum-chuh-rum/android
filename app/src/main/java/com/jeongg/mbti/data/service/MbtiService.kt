package com.jeongg.mbti.data.service

import com.jeongg.mbti.data.dtos.GetQuestionsDTO
import com.jeongg.mbti.data.dtos.PostAnswerRequestDTO
import com.jeongg.mbti.data.dtos.PostAnswerResponseDTO
import com.jeongg.mbti.data.dtos.QuestionDTO

interface MbtiService {
    suspend fun postAnswer(postAnswerRequestDTO: PostAnswerRequestDTO): PostAnswerResponseDTO?
    suspend fun getQuestions(): List<QuestionDTO>
}