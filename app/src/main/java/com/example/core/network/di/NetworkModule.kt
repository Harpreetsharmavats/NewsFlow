package com.example.core.network.di


import com.example.core.network.api.NewsApiService
import com.example.core.network.interceptor.ApiKeyInterceptor
import com.example.core.network.interceptor.LoggingInterceptor
import com.example.core.network.utils.NetworkConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object NetworkModule {

    @Provides
    @Singleton

    fun provideOkHttpClient():
            OkHttpClient {

        return OkHttpClient.Builder()

            .connectTimeout(
                30,
                TimeUnit.SECONDS
            )

            .readTimeout(
                30,
                TimeUnit.SECONDS
            )

            .writeTimeout(
                30,
                TimeUnit.SECONDS
            )

            .addInterceptor(
                ApiKeyInterceptor()
            )

            .addInterceptor(
                LoggingInterceptor.create()
            )

            .build()
    }

    @Provides
    @Singleton

    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {

        return Retrofit.Builder()

            .baseUrl(
                NetworkConstants.BASE_URL
            )

            .client(okHttpClient)

            .addConverterFactory(
                GsonConverterFactory.create()
            )

            .build()
    }

    @Provides
    @Singleton

    fun provideNewsApiService(
        retrofit: Retrofit
    ): NewsApiService {

        return retrofit.create(
            NewsApiService::class.java
        )
    }
}