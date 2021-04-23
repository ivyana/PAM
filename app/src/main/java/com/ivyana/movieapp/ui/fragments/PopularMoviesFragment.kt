package com.ivyana.movieapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.ivyana.movieapp.R
import com.ivyana.movieapp.ui.adapter.MoviesAdapter
import com.ivyana.movieapp.databinding.FragmentMovieBinding
import com.ivyana.movieapp.util.extensions.hide
import com.ivyana.movieapp.util.extensions.show
import com.ivyana.movieapp.util.extensions.toast
import com.ivyana.movieapp.ui.MovieViewModel
import com.ivyana.movieapp.util.Resource

class PopularMoviesFragment : Fragment(R.layout.fragment_movie) {


    private val viewModel : MovieViewModel by  activityViewModels()
    lateinit var moviesAdapter: MoviesAdapter
    lateinit var binding: FragmentMovieBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)

        setUpRecyclerView()

        moviesAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putParcelable("movie",it)
            }
            findNavController().navigate(R.id.action_movieFragment_to_movieDetailFragment, bundle)
        }

        viewModel.movies.observe(viewLifecycleOwner,  { response ->


            when (response) {
                is Resource.Success -> {
                    binding.progressBar.hide()
                    moviesAdapter.differ.submitList(response.data!!.results)
                }
                is Resource.Loading -> {
                    binding.progressBar.show()
                }
                is Resource.Error -> {
                    response.message.let { message ->
                        binding.progressBar.hide()
                        context?.toast(message.toString())
                    }
                }
            }


        })
    }

    private fun setUpRecyclerView() {

        moviesAdapter = MoviesAdapter()
        binding.recyclerView.adapter = moviesAdapter

    }



}
