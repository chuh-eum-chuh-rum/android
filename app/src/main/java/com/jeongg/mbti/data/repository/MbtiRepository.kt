package com.jeongg.mbti.data.repository

import com.jeongg.mbti.data.dtos.GetQuestionsDTO
import com.jeongg.mbti.data.dtos.PostAnswerRequestDTO
import com.jeongg.mbti.data.dtos.PostAnswerResponseDTO
import com.jeongg.mbti.data.service.MbtiService
import com.jeongg.mbti.data.util.getErrorMessage
import com.jeongg.mbti.data.util.log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MbtiRepository @Inject constructor(
    private val resultService: MbtiService
){
    suspend fun postAnswer(postAnswerRequestDTO: PostAnswerRequestDTO): PostAnswerResponseDTO? {
        return try {
            resultService.postAnswer(postAnswerRequestDTO)
        } catch(e: Exception) {
            val error = getErrorMessage(e)
            "[ERROR] postAnswer: ${error.second} ${error.first}".log()
            null
        }
    }
    suspend fun getQuestions(): GetQuestionsDTO? {
        return try {
            resultService.getQuestions()
        } catch(e: Exception){
            val error = getErrorMessage(e)
            "[ERROR] getQuestions: ${error.second} ${error.first}".log()
            null
        }
    }
}