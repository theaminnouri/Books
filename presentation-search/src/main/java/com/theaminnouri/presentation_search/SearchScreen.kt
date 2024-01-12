package com.theaminnouri.presentation_search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.theaminnouri.domain.entity.Book
import com.theaminnouri.presentation_common.state.CommonScreen
import com.theaminnouri.presentation_common.ui.theme.AppTheme
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SearchScreen(
    viewModel: SearchViewModel,
    navController: NavController
) {
    LaunchedEffect(Unit) {
        viewModel.submitAction(SearchUiAction.Search("clean code"))
    }
    viewModel.uiStateFlow.collectAsState().value.let { state ->
        CommonScreen(state = state) {
            SearchView(it)
        }
    }

    LaunchedEffect(Unit) {
        viewModel.singleEventFlow.collectLatest {
            // TODO: navigation will implement here 
        }
    }
}

@Composable
fun SearchView(searchModel: SearchModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = "Search ...", onValueChange = {

        })
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(searchModel.books) {
                Row(modifier = Modifier.padding(16.dp)) {
                    Text(text = it.name)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = it.author)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    AppTheme {
        val searchModel = SearchModel(
            query = "clean code",
            books = listOf(
                Book(
                    id = "111",
                    name = "Clean Code",
                    author = "Uncle Bob",
                    image = "imageUrl",
                    releaseData = "August 1, 2008"
                )
            )
        )
        SearchView(searchModel = searchModel)
    }
}
