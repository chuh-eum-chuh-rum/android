package com.jeongg.mbti.di

import android.content.Context
import android.util.Log
import com.jeongg.mbti.data.datasource.MbtiDataSource
import com.jeongg.mbti.data.repository.MbtiRepository
import com.jeongg.mbti.data.service.MbtiService
import com.jeongg.mbti.data.util.HttpRoutes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.endpoint
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
    fun provideHttpClient(): HttpClient {
        return HttpClient(CIO) {
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.d("mbti_api", message)
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
                connectTimeoutMillis = 7000
                requestTimeoutMillis = 7000
                socketTimeoutMillis = 7000
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
    fun provideMbtiService(client: HttpClient): MbtiService {
        return MbtiDataSource(client)
    }
    @Provides
    @Singleton
    fun provideSelectRepository(service: MbtiService): MbtiRepository {
        return MbtiRepository(service)
    }

}