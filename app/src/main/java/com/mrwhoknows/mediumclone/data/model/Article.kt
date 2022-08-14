package com.mrwhoknows.mediumclone.data.model

import com.mrwhoknows.mediumclone.data.entity.ArticleEntity
import java.util.*

data class Article(
    val id: Long,
    val title: String,
    val description: String,
    val createdAt: Date,
    val authorName: String,
    val wordCount: Long,
    val body: String,
    val tags: List<String>,
    val likes: Long
) {
    companion object {
        fun getDummyArticles(size: Int = 10) = (1..size).map {
            getDummyArticle(it)
        }

        fun getDummyArticle(id: Number? = null): Article {
            val body = "body: " + ('z' downTo 'a').shuffled().subList(0, Random().nextInt(26))
                .joinToString(separator = "") {
                    it.toString() + if (Random().nextBoolean()) " " else ""
                }
            return Article(
                id = id?.toLong() ?: Random().nextLong(),
                title = "Article: " + ('a'..'z').shuffled().subList(0, Random().nextInt(8))
                    .joinToString(separator = "") {
                        it.toString() + if (Random().nextBoolean()) " " else ""
                    },
                description = "desc: " + ('a'..'z').shuffled().subList(0, Random().nextInt(26))
                    .joinToString(separator = "") {
                        it.toString() + if (Random().nextBoolean()) " " else ""
                    },
                createdAt = Date(),
                authorName = "author",
                wordCount = body.length.toLong(),
                likes = 0,
                tags = emptyList(),
                body = body
            )
        }
    }
}

fun Article.toEntity() = ArticleEntity(
    id, title, description, createdAt, authorName, wordCount, body, tags, likes
)