package com.theaminnouri.presentation_search

import com.theaminnouri.domain.entity.Book

data class SearchModel(
    val query: String,
    val books: List<Book>
)
