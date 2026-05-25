package com.example.features.news.data.remote.dto

data class NewsResponseDto(

    val status: String?,

    val totalResults: Int?,

    val articles: List<ArticleDto>?
)