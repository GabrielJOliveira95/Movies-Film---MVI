package com.example.movieslist_mvi.ui.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.networking.response.main.movie.MovieResponse
import com.example.data.networking.response.similarmovies.SimilarMoviesResponse
import com.example.data.repository.MoviesRepository
import kotlinx.coroutines.coroutineScope

class MoviesListViewModel : ViewModel() {
    private val repository = MoviesRepository()
    private var _mainMovie = MutableLiveData<MovieResponse>()
    private var _allMovies = MutableLiveData<SimilarMoviesResponse>()
    val mainMovie = _mainMovie
    val allMovies = _allMovies


    suspend fun initView(initView: InitView) {
        coroutineScope {
            when (initView) {
                is InitView.LoadMainMovie -> {
                    val response = repository.getMainMovie()
                    if (response.isSuccessful) {
                        _mainMovie.value = response.body()
                    }
                }
                is InitView.LoadListMovies -> {
                    val response = repository.getSimilarMovies()
                    if (response.isSuccessful) {
                        _allMovies.value = response.body()
                    }
                }
            }
        }
    }
}

sealed class InitView() {
    object LoadMainMovie : InitView()
    object LoadListMovies : InitView()
}