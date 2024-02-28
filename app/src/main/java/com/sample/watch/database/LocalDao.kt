package com.sample.watch.database

import java.util.UUID
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sample.watch.model.Movie

@Dao
interface LocalDao {
    @Query("SELECT * FROM movie_table")
    fun getMovies(): List<Movie>
    @Query("SELECT * FROM movie_table WHERE id=(:id)")
    fun getMovie(id: UUID): Movie?
    @Insert
    fun insert(movie: Movie)
    @Update
    fun update(movie: Movie)
    @Delete
    fun delete(movie: Movie)
}