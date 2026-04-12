package com.example.bookself.ui

import android.net.http.HttpException
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookself.BookselfApplication
import com.example.bookself.data.BooksRepository
import com.example.bookself.model.BookItem
import com.example.bookself.model.ImageLinks
import kotlinx.coroutines.launch
import okio.IOException


sealed interface BookselfUiState {
    data class Success(val books: List<BookItem>) : BookselfUiState
    object Error : BookselfUiState
    object Loading : BookselfUiState
}

class BookselfViewModel(private val booksRepository: BooksRepository): ViewModel() {

    var bookselfUiState: BookselfUiState by mutableStateOf(BookselfUiState.Loading)
        private set


    init {
        getBooks("jazz history")
    }

    fun getBooks(query: String = "jazz history"){
        viewModelScope.launch {
            bookselfUiState = BookselfUiState.Loading
            bookselfUiState = try {
                BookselfUiState.Success(booksRepository.getBooks(query))
            } catch (e: Exception){
                BookselfUiState.Error
            }


        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BookselfApplication)
                val booksRepository = application.container.booksRepository
                BookselfViewModel(booksRepository = booksRepository )
            }
        }
    }
}