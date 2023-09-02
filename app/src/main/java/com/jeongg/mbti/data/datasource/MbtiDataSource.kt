package com.jeongg.mbti.data.datasource

import com.jeongg.mbti.data.dtos.GetQuestionsDTO
import com.jeongg.mbti.data.dtos.PostAnswerRequestDTO
import com.jeongg.mbti.data.dtos.PostAnswerResponseDTO
import com.jeongg.mbti.data.dtos.QuestionDTO
import com.jeongg.mbti.data.service.MbtiService
import com.jeongg.mbti.data.util.HttpRoutes
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class MbtiDataSource(
    private val client: HttpClient
): MbtiService {

    override suspend fun postAnswer(postAnswerRequestDTO: PostAnswerRequestDTO): PostAnswerResponseDTO? {
        return client.post(HttpRoutes.POST_ANSWER){
            setBody(postAnswerRequestDTO)
        }.body()
    }

    override suspend fun getQuestions(): List<QuestionDTO> {
        return client.get(HttpRoutes.GET_QUESTIONS).body()
    }
}