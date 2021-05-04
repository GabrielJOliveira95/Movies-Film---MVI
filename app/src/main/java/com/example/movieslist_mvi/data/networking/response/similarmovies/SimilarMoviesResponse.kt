package com.example.data.networking.response.similarmovies

data class SimilarMoviesResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)