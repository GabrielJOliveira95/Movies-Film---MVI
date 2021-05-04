package com.example.movieslist_mvi.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.movieslist_mvi.databinding.FragmentMoviesListBinding
import com.example.utils.AppConstants
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch

class MoviesListFragment : Fragment() {
    private lateinit var viewModel: MoviesListViewModel
    private lateinit var binding: FragmentMoviesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMoviesListBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(MoviesListViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observers()
    }

    private fun initView() {
        lifecycleScope.launch {
            viewModel.initView(InitView.LoadMainMovie)
            viewModel.initView(InitView.LoadListMovies)
        }
    }

    private fun observers() {
        viewModel.mainMovie.observe(viewLifecycleOwner, {
            Picasso.get()
                .load(AppConstants.BASE_URL_PHOTO + it.backdrop_path)
                .into(binding.mainMovieLogo)
            binding.movieScreenPb.visibility = View.GONE
            binding.mainMovieTitle.text = it.title
        })

        viewModel.allMovies.observe(viewLifecycleOwner, {

        })
    }
}