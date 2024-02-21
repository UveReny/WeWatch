package com.sample.watch.model

import androidx.room.Entity
import androidx.room.PrimaryKey

import java.util.UUID

data class Movie(
    val id: UUID = UUID.randomUUID(),
    val title: String = "",
    val year: String = "",
    val posterUrl: String? = null,
)
/*
@Entity(tableName = "movie_table")
data class Movie(
    @PrimaryKey
    @SerializedName("id")
    @Expose
    var id: Int? = null,
    @SerializedName("imdbID")
    @Expose
    var imdbID: String? = null,
    @SerializedName("Title")
    @Expose
    var title: String? = null,
    @SerializedName("Poster")
    @Expose
    var posterPath: String? = null,
    @SerializedName("Type")
    @Expose
    var overview: String? = null,
    @SerializedName("Year")
    @Expose
    var releaseDate: String? = null,
    var watched: Boolean = false) {
    fun getReleaseYearFromDate(): String? {
        return releaseDate?.split("-")?.get(0)
    }
}*/
