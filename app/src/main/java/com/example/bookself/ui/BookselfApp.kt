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
import com.example.bookself.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookSelfApp(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            BookSelfTopAppBar()
        }

    ) {values ->
        BookHomeScreen(
            modifier = Modifier.padding(values)
        )

    }
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