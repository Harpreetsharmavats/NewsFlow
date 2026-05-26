package com.example.features.news.presentation.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.features.news.presentation.component.NewsCard
import com.example.features.news.presentation.viewmodel.NewsViewModel


@Composable
fun NewsScreen(

    viewModel: NewsViewModel =
        hiltViewModel()

) {

    val state by
    viewModel.state
        .collectAsStateWithLifecycle()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        when {

            state.isLoading -> {

                CircularProgressIndicator(
                    modifier = Modifier.align(
                        Alignment.Center
                    )
                )
            }

            state.error.isNotEmpty() -> {

                Text(
                    text = state.error,
                    modifier = Modifier.align(
                        Alignment.Center
                    )
                )
            }

            else -> {

                LazyColumn(

                    modifier = Modifier.fillMaxSize(),

                    verticalArrangement =
                        Arrangement.spacedBy(12.dp),

                    contentPadding =
                        PaddingValues(16.dp)

                ) {

                    items(
                        state.articles
                    ) { article ->

                        NewsCard(
                            article = article
                        )
                    }
                }
            }
        }
    }
}