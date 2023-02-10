package com.example.searchmoviecompose.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.searchmoviecompose.database.entity.RecentSearchEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecentSearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun registerRecentSearchEntity(entity: RecentSearchDao): Long

    @Query("SELECT * FROM recent_search_table ORDER BY id DESC LIMIT 10")
    fun getAll(): Flow<List<RecentSearchEntity>>

}