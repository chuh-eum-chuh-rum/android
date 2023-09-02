package com.jeongg.mbti.data.repository

import com.jeongg.mbti.data.service.ResultService
import com.jeongg.mbti.data.service.SelectService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SelectRepository @Inject constructor(
    private val selectService: SelectService
){
}