package com.example.core.network.api


import com.example.features.news.data.remote.dto.NewsResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("top-headlines")

    suspend fun getTopHeadlines(

        @Query("country")
        country: String = "us",

        @Query("page")
        page: Int,


        @Query("pageSize")
        pageSize: Int

    ): Response<NewsResponseDto>
}