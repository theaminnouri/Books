package com.theaminnouri.data_repository.data_source.remote

import com.theaminnouri.domain.entity.Book
import kotlinx.coroutines.flow.Flow

interface BooksRemoteDataSource {

    fun getBooks(query: String): Flow<List<Book>>

    fun getBook(id: String): Flow<Book>
}