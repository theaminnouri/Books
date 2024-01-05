package com.theaminnouri.data_remote.injection

import com.theaminnouri.data_remote.source.BooksRemoteDataSourceImpl
import com.theaminnouri.data_repository.data_source.remote.BooksRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    abstract fun bindBooksDataSource(
        booksRemoteDataSourceImpl: BooksRemoteDataSourceImpl
    ): BooksRemoteDataSource
}
