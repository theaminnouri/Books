package com.theaminnouri.domain.usecase

import com.theaminnouri.domain.entity.Book
import com.theaminnouri.domain.repository.BooksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    configuration: Configuration,
    private val booksRepository: BooksRepository,
) : UseCase<SearchUseCase.Search, SearchUseCase.SearchResponse>(configuration = configuration) {


    override fun process(request: Search): Flow<SearchResponse> =
        booksRepository.getBooks(request.query).map {
            SearchResponse(request.query, it)
        }

    data class Search(val query: String) : Request

    data class SearchResponse(val query: String, val books: List<Book>) : Response
}
