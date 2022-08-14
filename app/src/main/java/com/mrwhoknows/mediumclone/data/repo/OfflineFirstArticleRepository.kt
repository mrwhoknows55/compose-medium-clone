package com.mrwhoknows.mediumclone.data.repo

import com.mrwhoknows.mediumclone.data.entity.ArticleEntity
import com.mrwhoknows.mediumclone.data.entity.asArticleMetaDataModel
import com.mrwhoknows.mediumclone.data.entity.asArticleModel
import com.mrwhoknows.mediumclone.data.model.Article
import com.mrwhoknows.mediumclone.data.model.ArticleMetadata
import com.mrwhoknows.mediumclone.data.source.db.ArticleDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OfflineFirstArticleRepository @Inject constructor(
    private val dao: ArticleDao
) : ArticleRepository {
    override fun getLatestArticles(): Flow<List<Article>> = dao.getLatestArticles().map {
        it.map(ArticleEntity::asArticleModel)
    }

    override fun getLatestArticlesMetadata(): Flow<List<ArticleMetadata>> =
        dao.getLatestArticles().map {
            it.map(ArticleEntity::asArticleMetaDataModel)
        }


    override fun getArticleById(id: Long): Flow<Article?> = dao.getArticleById(id).map {
        it?.asArticleModel()
    }
}
