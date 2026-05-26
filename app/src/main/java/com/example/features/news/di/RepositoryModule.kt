package com.example.features.news.di



import com.example.features.news.data.repository.NewsRepositoryImpl
import com.example.features.news.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

abstract class RepositoryModule {

    @Binds

    abstract fun bindNewsRepository(
        impl: NewsRepositoryImpl
    ): NewsRepository
}