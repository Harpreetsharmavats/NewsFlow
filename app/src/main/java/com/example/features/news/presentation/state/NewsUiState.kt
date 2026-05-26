package com.example.features.news.presentation.state

import androidx.compose.runtime.Immutable
import com.example.features.news.domain.model.Article

@Immutable
data class NewsUiState(

    val isLoading: Boolean = false,

    val articles: List<Article> = emptyList(),

    val error: String = ""
)