package com.example.features.news.presentation.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.core.network.utils.NetworkResult
import com.example.features.news.domain.usecases.GetTopHeadlinesUseCase
import com.example.features.news.presentation.state.NewsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(

    getTopHeadlinesUseCase:
    GetTopHeadlinesUseCase

) : ViewModel() {

    val articles =

        getTopHeadlinesUseCase()
            .cachedIn(viewModelScope)
}