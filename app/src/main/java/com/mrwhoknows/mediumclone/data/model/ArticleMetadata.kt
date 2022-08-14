package com.mrwhoknows.mediumclone.data.model

import java.util.*

data class ArticleMetadata(
    val id: Long,
    val title: String,
    val description: String,
    val createdAt: Date,
    val authorName: String,
    val wordCount: Long,
    val tags: List<String>,
    val likes: Long
)