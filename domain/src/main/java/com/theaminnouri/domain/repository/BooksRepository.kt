package com.theaminnouri.domain.repository

import com.theaminnouri.domain.entity.Book
import kotlinx.coroutines.flow.Flow

interface BooksRepository {

    fun getBooks(query: String): Flow<List<Book>>

    fun getBook(id: String): Flow<Book>
}
