package com.example.newsflow

import androidx.paging.PagingData
import app.cash.turbine.test
import com.example.features.news.domain.usecases.GetTopHeadlinesUseCase
import com.example.features.news.presentation.viewmodel.NewsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class NewsViewModelTest {

    private val dispatcher =
        StandardTestDispatcher()

    @Before
    fun setup() {

        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {

        Dispatchers.resetMain()
    }

    @Test
    fun `articles flow emits paging data`() = runTest {

        val repository =
            FakeNewsRepository()

        val useCase =
            GetTopHeadlinesUseCase(
                repository
            )

        val viewModel =
            NewsViewModel(useCase)

        viewModel.articles.test {

            val item = awaitItem()

            assert(item is PagingData<*>)

            cancelAndIgnoreRemainingEvents()
        }
    }
}