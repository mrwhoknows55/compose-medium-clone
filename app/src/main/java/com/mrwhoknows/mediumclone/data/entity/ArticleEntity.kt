package com.mrwhoknows.mediumclone.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.mrwhoknows.mediumclone.data.model.Article
import com.mrwhoknows.mediumclone.data.model.ArticleMetadata
import java.util.*

@Entity(tableName = "article")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val description: String,
    val createdAt: Date,
    val authorName: String,
    val wordCount: Long,
    val body: String,
    val tags: List<String>,
    val likes: Long
)

class ArticleTypeConverters {
    @TypeConverter
    fun fromTimestamp(timestamp: Long): Date = Date(timestamp)

    @TypeConverter
    fun dateToTimestamp(date: Date): Long = date.time

    @TypeConverter
    fun fromListOfStrings(listOfStrings: List<String>): String = listOfStrings.joinToString("," )

    @TypeConverter
    fun fromCommaSeparatedString(csv: String): List<String> = csv.split(",")
}

fun ArticleEntity.asArticleModel() = Article(
    id = id,
    title = title,
    description = description,
    createdAt = createdAt,
    authorName = authorName,
    wordCount = wordCount,
    body = body,
    tags = tags,
    likes = likes
)

fun ArticleEntity.asArticleMetaDataModel() = ArticleMetadata(
    id = id,
    title = title,
    description = description,
    createdAt = createdAt,
    authorName = authorName,
    wordCount = wordCount,
    tags = tags,
    likes = likes
)
