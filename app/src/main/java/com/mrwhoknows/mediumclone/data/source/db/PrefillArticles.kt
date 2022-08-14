package com.mrwhoknows.mediumclone.data.source.db

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mrwhoknows.mediumclone.data.model.Article
import com.mrwhoknows.mediumclone.data.model.toEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Provider

class PrefillArticles(private val daoProvider: Provider<ArticleDao>) : RoomDatabase.Callback() {

    private val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        applicationScope.launch(Dispatchers.IO) {
            daoProvider.get().insertArticles(Article.getDummyArticles().map {
                it.toEntity()
            })
        }
    }

}