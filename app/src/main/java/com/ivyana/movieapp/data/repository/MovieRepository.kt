package com.ivyana.movieapp.data.repository

import com.ivyana.movieapp.data.remote.RetrofitInstance
import com.ivyana.movieapp.data.local.MovieDatabase
import com.ivyana.movieapp.models.Result

class MovieRepository(private val db : MovieDatabase) {

    suspend fun  getPopularMovies() = RetrofitInstance.api.getPopularMovies()
    suspend fun  getLatestMovies() = RetrofitInstance.api.getLatestMovies()
    suspend fun upsert (movie: Result) = db.getMovieDAO().upsert(movie)
    fun getSavedMovie() = db.getMovieDAO().getAllMovie()
    suspend fun  deleteMovie(movie: Result) = db.getMovieDAO().deleteMovie(movie)
}