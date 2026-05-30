package com.example.features.news.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.features.news.presentation.component.ErrorItem
import com.example.features.news.presentation.component.NewsCard
import com.example.features.news.presentation.component.ShimmerNewsCard
import com.example.features.news.presentation.viewmodel.NewsViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(
    viewModel: NewsViewModel = hiltViewModel()
) {

    val articles =
        viewModel.articles.collectAsLazyPagingItems()

    Scaffold(

        topBar = {

            TopAppBar(

                title = {
                    Text("NewsFlow")
                },

                actions = {

                    IconButton(

                        onClick = {

                            articles.refresh()
                        }

                    ) {

                        Icon(
                            imageVector =
                                Icons.Default.Refresh,

                            contentDescription =
                                "Refresh"
                        )
                    }
                }
            )
        }

    ) { paddingValues ->

        when (articles.loadState.refresh) {

            is LoadState.Loading -> {

                ShimmerNewsCard()
            }

            is LoadState.Error -> {

                ErrorItem(
                    message = "Failed to load news",
                    onRetry = {
                        articles.retry()
                    }
                )
            }

            else -> {

                val pagerState = rememberPagerState(
                    pageCount = {
                        articles.itemCount
                    }
                )

                VerticalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) { page ->

                    articles[page]?.let { article ->

                        NewsCard(article)
                    }
                }
            }
        }
    }
}