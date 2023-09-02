package com.jeongg.mbti.di

import android.content.Context
import android.util.Log
import com.jeongg.mbti.data.datasource.ResultDataSource
import com.jeongg.mbti.data.datasource.SelectDataSource
import com.jeongg.mbti.data.repository.ResultRepository
import com.jeongg.mbti.data.repository.SelectRepository
import com.jeongg.mbti.data.service.ResultService
import com.jeongg.mbti.data.service.SelectService
import com.jeongg.mbti.data.util.HttpRoutes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.compression.ContentEncoding
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideHttpClient(
        @ApplicationContext context: Context
    ): HttpClient {
        return HttpClient(CIO) {
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.d("ppap_api", message)
                    }
                }
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    encodeDefaults = true
                })
            }
            install(HttpTimeout) {
                connectTimeoutMillis = 5000
                requestTimeoutMillis = 5000
                socketTimeoutMillis = 5000
            }
            install(ContentEncoding) {
                deflate(1.0F)
                gzip(0.9F)
            }
            defaultRequest {
                contentType(ContentType.Application.Json)
                url(HttpRoutes.BASE_URL)
            }
        }
    }
    @Provides
    @Singleton
    fun provideSelectService(client: HttpClient): SelectService {
        return SelectDataSource(client)
    }
    @Provides
    @Singleton
    fun provideSelectRepository(service: SelectService): SelectRepository {
        return SelectRepository(service)
    }
    @Provides
    @Singleton
    fun provideResultService(client: HttpClient): ResultService {
        return ResultDataSource(client)
    }
    @Provides
    @Singleton
    fun provideResultRepository(service: ResultService): ResultRepository {
        return ResultRepository(service)
    }
}