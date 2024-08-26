package com.cindy.movieapp.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cindy.movieapp.core.ui.MovieAdapter
import com.cindy.movieapp.favorite.databinding.FragmentFavoriteBinding
import com.cindy.movieapp.favorite.di.movieModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null

    private val binding get() = _binding!!
    private val favoriteViewModel: FavoriteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadKoinModules(movieModule)

        if (activity != null) {

            val movieAdapter = MovieAdapter { selectedMovie ->
                val action =
                    FavoriteFragmentDirections.actionNavigationFavoriteToNavigationDetail(selectedMovie)
                findNavController().navigate(action)
            }

            favoriteViewModel.favoriteMovie.observe(viewLifecycleOwner) { dataMovie ->
                movieAdapter.submitList(dataMovie)
                binding.viewEmpty.root.visibility =
                    if (dataMovie.isNotEmpty()) View.GONE else View.VISIBLE
            }

            with(binding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}