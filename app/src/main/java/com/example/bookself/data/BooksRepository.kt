package com.example.bookself.data

import com.example.bookself.model.BookItem
import com.example.bookself.network.BooksApiService


fun String?.toHttps(): String? {
    return this?.replace("http://", "https://")
}

interface BooksRepository {

    suspend fun getBooks(searchTerm: String): List<BookItem>
}

class NetworkBooksRepository(
    private val bookApiService: BooksApiService
) : BooksRepository{
    override suspend fun getBooks(searchTerm: String): List<BookItem> {
        val response = bookApiService.searchBooks(searchTerm)
        return response.items.map{book->
            val fixedImageLinks = book.volumeInfo.imageLinks?.copy(
                thumbnail = book.volumeInfo.imageLinks.thumbnail.toHttps()
            )

            val fixedVolumeInfo = book.volumeInfo.copy(
                imageLinks = fixedImageLinks
            )

            book.copy(
                volumeInfo = fixedVolumeInfo
            )



        }

    }
}