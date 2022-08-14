package com.mrwhoknows.mediumclone.di

import com.mrwhoknows.mediumclone.data.repo.ArticleRepository
import com.mrwhoknows.mediumclone.data.repo.OfflineFirstArticleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsArticleRepository(articleRepo: OfflineFirstArticleRepository): ArticleRepository
}