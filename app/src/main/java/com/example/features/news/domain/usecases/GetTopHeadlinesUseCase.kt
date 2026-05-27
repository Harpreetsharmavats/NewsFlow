package com.example.features.news.domain.usecases

import com.example.features.news.domain.repository.NewsRepository
import javax.inject.Inject

class GetTopHeadlinesUseCase @Inject constructor(

    private val repository: NewsRepository

) {

    operator fun invoke() =

        repository.getTopHeadlines()
}