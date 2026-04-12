package com.example.bookself.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookself.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookSelfApp(
    modifier: Modifier = Modifier
){

    val bookselfViewModel : BookselfViewModel = viewModel(factory = BookselfViewModel.Factory )


        BookHomeScreen(
            modifier = modifier,
            bookUiState = bookselfViewModel.bookselfUiState,
            retryAction = { bookselfViewModel.getBooks() }
        )

    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookSelfTopAppBar(){
    CenterAlignedTopAppBar(
        title = {
            Text(stringResource(R.string.app_title))
        },

    )
}