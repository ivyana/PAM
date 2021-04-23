package com.ivyana.movieapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.ivyana.movieapp.BR
import com.ivyana.movieapp.R
import com.ivyana.movieapp.databinding.FragmentMovieDetailBinding
import com.ivyana.movieapp.ui.MovieViewModel

class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {


    private val args: MovieDetailFragmentArgs by navArgs()
    private val viewModel : MovieViewModel by activityViewModels()
    lateinit var binding: FragmentMovieDetailBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMovieDetailBinding.bind(view)

        binding.apply {
            binding.setVariable(BR.movie,args.movie)
        }

        binding.fab.setOnClickListener {
            viewModel.saveArticle(args.movie)
            Snackbar.make(requireView(), "Movie Saved Successfully", Snackbar.LENGTH_SHORT).show()
        }
    }


}