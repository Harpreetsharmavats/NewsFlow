package com.example.features.news.domain.repository

import androidx.paging.PagingData
import com.example.features.news.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getTopHeadlines():

            Flow<PagingData<Article>>
}