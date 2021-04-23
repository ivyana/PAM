package com.ivyana.movieapp.data.remote


import com.ivyana.movieapp.models.MoviesModel

import com.ivyana.movieapp.util.Constants.Companion.API_KEY
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

   @GET("/3/movie/popular")
   suspend fun getPopularMovies(
       @Query("api_key")
       api_key: String = API_KEY
   ) : Response<MoviesModel>

    @GET("/3/movie/top_rated")
    suspend fun getLatestMovies(
        @Query("api_key")
        api_key: String = API_KEY
    ) : Response <MoviesModel>

}