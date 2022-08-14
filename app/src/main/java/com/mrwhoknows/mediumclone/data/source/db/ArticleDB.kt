package com.mrwhoknows.mediumclone.data.source.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mrwhoknows.mediumclone.data.entity.ArticleEntity
import com.mrwhoknows.mediumclone.data.entity.ArticleTypeConverters

@Database(
    entities = [
        ArticleEntity::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(ArticleTypeConverters::class)
abstract class ArticleDB : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}