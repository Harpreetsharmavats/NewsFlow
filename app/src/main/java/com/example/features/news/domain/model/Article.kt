package com.example.features.news.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class Article(

    val title: String,

    val description: String,

    val imageUrl: String,

    val source: String,

    val publishedAt: String,

    val articleUrl: String
)