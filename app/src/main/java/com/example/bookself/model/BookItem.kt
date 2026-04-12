package com.example.bookself.model

import kotlinx.serialization.Serializable


@Serializable
data class BookResponse(
    val items: List<BookItem> = emptyList()
)

@Serializable
data class BookItem(
    val id: String,
    val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    val title: String? = null,
    val authors: List<String>? = emptyList(),
    val description: String? = null,
    val imageLinks: ImageLinks? = null
)

@Serializable
data class ImageLinks(
    val thumbnail: String? = null

)
