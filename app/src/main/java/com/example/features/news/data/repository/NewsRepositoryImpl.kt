package com.example.features.news.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.core.network.api.NewsApiService
import com.example.core.network.api.safeApiCall
import com.example.core.network.utils.NetworkResult
import com.example.features.news.data.mapper.toDomain
import com.example.features.news.data.paging.NewsPagingSource
import com.example.features.news.domain.model.Article
import com.example.features.news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class NewsRepositoryImpl @Inject constructor(

    private val api: NewsApiService

) : NewsRepository {

    override fun getTopHeadlines():

            Flow<PagingData<Article>> {

        return Pager(

            config = PagingConfig(

                pageSize = 20,

                prefetchDistance = 5,

                enablePlaceholders = false
            ),

            pagingSourceFactory = {

                NewsPagingSource(api)
            }

        ).flow
    }
}