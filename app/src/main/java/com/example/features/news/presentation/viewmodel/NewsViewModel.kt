package com.example.features.news.presentation.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    private val getTopHeadlinesUseCase:
    GetTopHeadlinesUseCase

) : ViewModel() {

    private val _state =

        MutableStateFlow(
            NewsUiState()
        )

    val state =
        _state.asStateFlow()

    init {
        getTopHeadlines()
    }

    private fun getTopHeadlines() {

        viewModelScope.launch {

            _state.update {

                it.copy(
                    isLoading = true
                )
            }

            when (

                val result =
                    getTopHeadlinesUseCase()

            ) {

                is NetworkResult.Success -> {

                    _state.update {

                        it.copy(
                            isLoading = false,
                            articles = result.data
                        )
                    }
                }

                is NetworkResult.Error -> {

                    _state.update {

                        it.copy(
                            isLoading = false,
                            error = result.message
                        )
                    }
                }

                else -> Unit
            }
        }
    }
}