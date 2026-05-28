package com.example.features.news.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.features.news.presentation.component.ErrorItem
import com.example.features.news.presentation.component.NewsCard
import com.example.features.news.presentation.component.ShimmerNewsCard
import com.example.features.news.presentation.viewmodel.NewsViewModel


@Composable
fun NewsScreen(

    viewModel: NewsViewModel =
        hiltViewModel()

) {
    val articles =

        viewModel.articles
            .collectAsLazyPagingItems()
    val refreshState =
        rememberPullToRefreshState()

    PullToRefreshBox(

        isRefreshing =

            articles.loadState.refresh
                    is LoadState.Loading,

        onRefresh = {

            articles.refresh()
        },

        state = refreshState

    ) {


        LazyColumn(

            modifier = Modifier.fillMaxSize(),

            verticalArrangement =
                Arrangement.spacedBy(12.dp),

            contentPadding =
                PaddingValues(16.dp)

        ) {

            when (

                articles.loadState.refresh

            ) {

                is LoadState.Loading -> {

                    items(6) {

                        ShimmerNewsCard()
                    }
                }

                is LoadState.Error -> {

                    item {

                        ErrorItem(

                            message = "Failed to load news",

                            onRetry = {

                                articles.retry()
                            }
                        )
                    }
                }

                else -> {

                    items(

                        count =
                            articles.itemCount

                    ) { index ->

                        articles[index]
                            ?.let { article ->

                                NewsCard(article)
                            }
                    }
                }
            }

            if (

                articles.loadState.append
                        is LoadState.Loading

            ) {

                item {

                    CircularProgressIndicator()
                }
            }
        }
    }
}