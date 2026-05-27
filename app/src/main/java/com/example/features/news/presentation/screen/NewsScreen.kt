package com.example.features.news.presentation.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.features.news.presentation.component.NewsCard
import com.example.features.news.presentation.viewmodel.NewsViewModel


@Composable
fun NewsScreen(

    viewModel: NewsViewModel =
        hiltViewModel()

) {

    val articles =

        viewModel.articles
            .collectAsLazyPagingItems()

    LazyColumn(

        modifier = Modifier.fillMaxSize(),

        verticalArrangement =
            Arrangement.spacedBy(12.dp),

        contentPadding =
            PaddingValues(16.dp)

    ) {

        items(

            count = articles.itemCount

        ) { index ->

            articles[index]?.let { article ->

                NewsCard(article)
            }
        }
    }
}