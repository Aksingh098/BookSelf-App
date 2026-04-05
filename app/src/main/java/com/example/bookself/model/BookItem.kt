package com.example.bookself.model

import kotlinx.serialization.Serializable


@Serializable
data class BookResponse(
    val items: List<BookItem> = emptyList() // The API returns 'items'
)

@Serializable
data class BookItem(
    val id: String,
    val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    val title: String,
    val authors: List<String>,
    val description: String,
    val imageLinks: ImageLinks? = null
)

@Serializable
data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String

)
