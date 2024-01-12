package com.theaminnouri.presentation_search

import com.theaminnouri.presentation_common.state.UiAction

sealed class SearchUiAction() : UiAction {

    data class Search(val query: String) : SearchUiAction()
}
