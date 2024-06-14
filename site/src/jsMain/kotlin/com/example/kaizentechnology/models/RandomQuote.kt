package com.example.kaizentechnology.models

import kotlinx.serialization.Serializable

@Serializable
data class RandomQuote (
    val _id: String?,
    val content: String,
    val author: String = "",
    val tags: List<String> = listOf(),
    val authorSlug: String = "",
    val length: Int = 0,
    val dateAdded: String = "",
    val dateModified: String = ""
)