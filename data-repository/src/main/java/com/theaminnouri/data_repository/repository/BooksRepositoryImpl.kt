package com.theaminnouri.data_repository.repository

import com.theaminnouri.data_repository.data_source.remote.BooksRemoteDataSource
import com.theaminnouri.domain.entity.Book
import com.theaminnouri.domain.repository.BooksRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

data class BooksRepositoryImpl @Inject constructor(val remoteDataSource: BooksRemoteDataSource) :
    BooksRepository {
    override fun getBooks(query: String): Flow<List<Book>> =
        remoteDataSource.getBooks(query = query)

    override fun getBook(id: String): Flow<Book> =
        remoteDataSource.getBook(id = id)
}
