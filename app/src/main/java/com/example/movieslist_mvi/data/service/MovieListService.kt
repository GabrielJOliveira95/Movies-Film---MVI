package com.example.movieslist_mvi.data.service

import com.example.data.networking.response.main.movie.MovieResponse
import com.example.data.networking.response.similarmovies.SimilarMoviesResponse
import com.example.utils.AppConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieListService {
    @GET("movie/{movie_id}")
    suspend fun getMainMovie(
        @Path("movie_id") movie_id: Int = AppConstants.MOVIE_ID,
        @Query("api_key") api_key: String = AppConstants.API_KEY
    ): Response<MovieResponse>

    @GET("movie/{movie_id}/similar")
    suspend fun getListMovie(
        @Path("movie_id") movie_id: Int = AppConstants.MOVIE_ID,
        @Query("api_key") api_key: String = AppConstants.API_KEY
    ): Response<SimilarMoviesResponse>
}