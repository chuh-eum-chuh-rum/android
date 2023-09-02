package com.jeongg.mbti.data.repository

import com.jeongg.mbti.data.service.ResultService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResultRepository @Inject constructor(
    private val resultService: ResultService
){
}