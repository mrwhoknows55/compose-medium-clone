package com.mrwhoknows.mediumclone.data.repo

import com.mrwhoknows.mediumclone.data.model.Article
import com.mrwhoknows.mediumclone.data.model.ArticleMetadata
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {

    fun getLatestArticles(): Flow<List<Article>>
    fun getLatestArticlesMetadata(): Flow<List<ArticleMetadata>>
    fun getArticleById(id: Long): Flow<Article?>

}
