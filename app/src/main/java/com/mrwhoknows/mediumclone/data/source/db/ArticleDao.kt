package com.mrwhoknows.mediumclone.data.source.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mrwhoknows.mediumclone.data.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {
    @Query("SELECT * FROM article ORDER BY createdAt DESC")
    fun getLatestArticles(): Flow<List<ArticleEntity>>

    @Query("SELECT * FROM article WHERE id = :id")
    fun getArticleById(id: Long): Flow<ArticleEntity?>

    @Insert
    suspend fun insertArticles(articles: List<ArticleEntity>)
}
