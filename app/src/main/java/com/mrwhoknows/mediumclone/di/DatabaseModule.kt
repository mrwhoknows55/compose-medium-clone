package com.mrwhoknows.mediumclone.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mrwhoknows.mediumclone.BuildConfig
import com.mrwhoknows.mediumclone.data.source.db.ArticleDB
import com.mrwhoknows.mediumclone.data.source.db.ArticleDao
import com.mrwhoknows.mediumclone.data.source.db.PrefillArticles
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun providesArticleDBBuilder(
        @ApplicationContext context: Context,
    ): RoomDatabase.Builder<ArticleDB> = Room.databaseBuilder(
        context,
        ArticleDB::class.java,
        "article"
    )

    @Provides
    @Singleton
    fun providesArticleDB(
        dbBuilder: RoomDatabase.Builder<ArticleDB>,
        provider: Provider<ArticleDao>
    ): ArticleDB {
        if (BuildConfig.DEBUG)
            dbBuilder.addCallback(PrefillArticles(provider))
        return dbBuilder.build()
    }

    @Provides
    @Singleton
    fun provideArticleDao(articleDB: ArticleDB): ArticleDao = articleDB.articleDao()

}