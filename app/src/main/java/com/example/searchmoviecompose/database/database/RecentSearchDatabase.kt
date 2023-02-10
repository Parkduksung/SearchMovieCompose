package com.example.searchmoviecompose.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.searchmoviecompose.database.dao.RecentSearchDao
import com.example.searchmoviecompose.database.entity.RecentSearchEntity

@Database(entities = [RecentSearchEntity::class], version = 1)
abstract class RecentSearchDatabase : RoomDatabase() {

    abstract fun recentSearchDao(): RecentSearchDao
}