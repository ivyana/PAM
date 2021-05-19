package com.ivyana.movieapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ivyana.movieapp.models.Result

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(movie : Result): Long

    @Query("SELECT * FROM movies")
    fun getAllMovie(): LiveData<List<Result>>

    @Delete
    suspend fun deleteMovie(movie: Result)
}