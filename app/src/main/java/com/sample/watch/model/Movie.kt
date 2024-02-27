package com.sample.watch.model

import java.util.UUID
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
data class Movie(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    var imdbID: String = "",
    var title: String = "",
    var posterPath: String = "",
    var overview: String = "",
    var releaseDate: String = "",
    var watched: Boolean = false,)
