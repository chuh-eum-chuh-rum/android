package com.jeongg.mbti.data.datasource

import com.jeongg.mbti.data.service.ResultService
import io.ktor.client.HttpClient

class ResultDataSource(
    private val client: HttpClient
): ResultService {
}