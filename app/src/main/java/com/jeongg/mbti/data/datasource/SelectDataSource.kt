package com.jeongg.mbti.data.datasource

import com.jeongg.mbti.data.service.SelectService
import io.ktor.client.HttpClient

class SelectDataSource(
    private val client: HttpClient
): SelectService {
}