package com.example.searchmoviecompose.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recent_search_table")
class RecentSearchEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "actor") var actor: String? = "",
    @ColumnInfo(name = "director") var director: String? = "",
    @ColumnInfo(name = "image") var image: String? = "",
    @ColumnInfo(name = "link") var link: String? = "",
    @ColumnInfo(name = "pubDate") var pubDate: String? = "",
    @ColumnInfo(name = "subtitle") var subtitle: String? = "",
    @ColumnInfo(name = "title") var title: String? = "",
    @ColumnInfo(name = "userRating") var userRating: String? = ""
)
