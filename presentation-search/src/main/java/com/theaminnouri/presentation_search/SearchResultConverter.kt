package com.theaminnouri.presentation_search

import com.theaminnouri.domain.usecase.SearchUseCase
import com.theaminnouri.presentation_common.state.CommonResultConvertor
import javax.inject.Inject

class SearchResultConverter @Inject constructor() :
    CommonResultConvertor<SearchUseCase.SearchResponse, SearchModel>() {
    override fun convertSuccess(data: SearchUseCase.SearchResponse): SearchModel =
        SearchModel(
            query = data.query,
            books = data.books,
        )
}
