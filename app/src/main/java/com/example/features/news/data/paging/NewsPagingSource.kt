package com.example.features.news.data.paging


import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.core.network.api.NewsApiService
import com.example.features.news.data.mapper.toDomain
import com.example.features.news.domain.model.Article
import retrofit2.HttpException
import java.io.IOException

class NewsPagingSource(

    private val api: NewsApiService

) : PagingSource<Int, Article>() {

    override suspend fun load(

        params: LoadParams<Int>

    ): LoadResult<Int, Article> {

        return try {

            val currentPage =
                params.key ?: 1

            val response =
                api.getTopHeadlines(

                    page = currentPage,

                    pageSize = 10
                )

            val articles =

                response.body()
                    ?.articles
                    ?.map { dto ->

                        dto.toDomain()
                    }
                    ?: emptyList()

            LoadResult.Page(

                data = articles,

                prevKey =
                    if (currentPage == 1)
                        null
                    else
                        currentPage - 1,

                nextKey =
                    if (articles.isEmpty())
                        null
                    else
                        currentPage + 1
            )

        } catch (e: IOException) {

            LoadResult.Error(e)

        } catch (e: HttpException) {

            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(

        state: PagingState<Int, Article>

    ): Int? {

        return state.anchorPosition
    }
}