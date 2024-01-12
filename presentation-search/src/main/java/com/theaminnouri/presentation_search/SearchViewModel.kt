package com.theaminnouri.presentation_search

import androidx.lifecycle.viewModelScope
import com.theaminnouri.domain.usecase.SearchUseCase
import com.theaminnouri.presentation_common.state.MviViewModel
import com.theaminnouri.presentation_common.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchResultConvertor: SearchResultConverter,
    private val searchUseCase: SearchUseCase
) :
    MviViewModel<SearchModel, UiState<SearchModel>, SearchUiAction, SearchUiEvent>() {
    override fun initState() = UiState.Loading

    override fun handleAction(action: SearchUiAction) {
        when (action) {
            is SearchUiAction.Search -> {
                search(action.query)
            }
        }
    }

    private fun search(query: String) {
        viewModelScope.launch {
            searchUseCase.execute(SearchUseCase.Search(query = query)).collect {
                submitState(searchResultConvertor.convert(it))
            }
        }
    }

}
