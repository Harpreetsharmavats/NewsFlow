package com.example.features.news.data.mapper

import com.example.features.news.data.remote.dto.ArticleDto
import com.example.features.news.domain.model.Article

fun ArticleDto.toDomain(): Article {

    return Article(

        title = title.orEmpty(),

        description = description.orEmpty(),

        imageUrl = urlToImage.orEmpty(),

        source = source?.name.orEmpty(),

        publishedAt = publishedAt.orEmpty(),

        articleUrl = url.orEmpty()
    )
}