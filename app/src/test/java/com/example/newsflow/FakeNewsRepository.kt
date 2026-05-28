package com.example.newsflow

import com.example.features.news.domain.model.Article
import com.example.features.news.domain.repository.NewsRepository
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeNewsRepository : NewsRepository {

    override fun getTopHeadlines():
            Flow<PagingData<Article>> {

        return flowOf(
            PagingData.from(
                listOf(
                    Article(
                        title = "Test News",
                        description = "Description",
                        imageUrl = "",
                        source = "BBC",
                        publishedAt = "Today",
                        articleUrl = "url"
                    )
                )
            )
        )
    }
}