package com.example.features.news.data.repository

import com.example.core.network.api.NewsApiService
import com.example.core.network.api.safeApiCall
import com.example.core.network.utils.NetworkResult
import com.example.features.news.data.mapper.toDomain
import com.example.features.news.domain.model.Article
import com.example.features.news.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(

    private val api: NewsApiService

) : NewsRepository {

    override suspend fun getTopHeadlines():

            NetworkResult<List<Article>> {

        val result = safeApiCall {

            api.getTopHeadlines(
                page = 1,
                pageSize = 20
            )
        }

        return when (result) {

            is NetworkResult.Success -> {

                val articles =
                    result.data.articles
                        ?.map { it.toDomain() }
                        ?: emptyList()

                NetworkResult.Success(
                    articles
                )
            }

            is NetworkResult.Error -> {

                NetworkResult.Error(
                    result.message
                )
            }

            else -> {

                NetworkResult.Error(
                    "Unknown Error"
                )
            }
        }
    }
}