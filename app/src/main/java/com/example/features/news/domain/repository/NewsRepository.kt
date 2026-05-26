package com.example.features.news.domain.repository

import com.example.core.network.utils.NetworkResult
import com.example.features.news.domain.model.Article

interface NewsRepository {

    suspend fun getTopHeadlines():

            NetworkResult<List<Article>>
}