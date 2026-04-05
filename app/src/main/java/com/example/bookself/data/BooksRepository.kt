package com.example.bookself.data

import com.example.bookself.model.BookItem
import com.example.bookself.network.BooksApiService

interface BooksRepository {

    suspend fun getBooks(searchTerm: String): List<BookItem>
}

class NetworkBooksRepository(
    private val bookApiService: BooksApiService
) : BooksRepository{
    override suspend fun getBooks(searchTerm: String): List<BookItem> {
        return bookApiService.searchBooks(searchTerm).items

    }
}