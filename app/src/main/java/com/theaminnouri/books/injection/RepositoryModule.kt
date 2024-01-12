package com.theaminnouri.books.injection

import com.theaminnouri.data_repository.data_source.remote.BooksRemoteDataSource
import com.theaminnouri.data_repository.repository.BooksRepositoryImpl
import com.theaminnouri.domain.repository.BooksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideBooksRepository(
        booksRemoteDataSource: BooksRemoteDataSource
    ): BooksRepository = BooksRepositoryImpl(booksRemoteDataSource)
}
