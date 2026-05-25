package com.example.features.news.data.remote

import com.example.features.news.data.remote.dto.NewsResponseDto
import okhttp3.Response
import retrofit2.http.Query

suspend fun getTopHeadlines(

    @Query("country")
    country: String = "us",

    @Query("page")
    page: Int,

    @Query("pageSize")
    pageSize: Int

): Response<NewsResponseDto>