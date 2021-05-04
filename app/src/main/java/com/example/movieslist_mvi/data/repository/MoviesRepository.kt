package com.example.data.repository

import retrofit2.Response
import com.example.data.Retrofit
import com.example.data.networking.response.main.movie.MovieResponse
import com.example.data.networking.response.similarmovies.SimilarMoviesResponse

class MoviesRepository {
    private val retrofit = Retrofit()

    suspend fun getMainMovie(): Response<MovieResponse> {
        val response = retrofit.getRetrofit().getMainMovie()
        try {
            if (response.isSuccessful) return response
        } catch (e: Exception) {
           throw e
        }
        return response
    }

    suspend fun getSimilarMovies(): Response<SimilarMoviesResponse> {
        val response = retrofit.getRetrofit().getListMovie()
        try {
            if (response.isSuccessful) return response
        } catch (e: Exception) {
            throw e
        }
        return response
    }
}