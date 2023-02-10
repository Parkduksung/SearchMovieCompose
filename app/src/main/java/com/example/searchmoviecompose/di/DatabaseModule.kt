package com.example.searchmoviecompose.di

import android.content.Context
import androidx.room.Room
import com.example.searchmoviecompose.database.dao.RecentSearchDao
import com.example.searchmoviecompose.database.database.RecentSearchDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideRecentSearchDao(recentSearchDatabase: RecentSearchDatabase): RecentSearchDao {
        return recentSearchDatabase.recentSearchDao()
    }

    @Provides
    @Singleton
    fun provideRecentSearchDatabase(@ApplicationContext appContext: Context): RecentSearchDatabase {
        return Room.databaseBuilder(
            appContext,
            RecentSearchDatabase::class.java,
            "recent_search_table"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

}