package com.ivyana.movieapp.models

data class MoviesModel(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)