package com.cindy.movieapp.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.cindy.movieapp.R
import com.cindy.movieapp.core.domain.model.Movie
import com.cindy.movieapp.databinding.FragmentDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val detailViewModel: DetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: DetailFragmentArgs by navArgs()
        val movie = args.movie
        showDetailMovie(movie)
    }

    private fun showDetailMovie(detailMovie: Movie?) {
        detailMovie?.let {
            with(binding){
                title.text = detailMovie.title
                Glide.with(requireContext())
                    .load(context?.getString(R.string.baseUrlImage, detailMovie.backdropPath))
                    .into(imgBackdrop)
                val releaseYear = detailMovie.releaseDate.take(4)
                val language = detailMovie.originalLanguage.uppercase()
                languagenyear.text = getString(R.string.language_release_year, language, releaseYear)
                val formattedNumber = String.format("%.2f", detailMovie.voteAverage)
                voteAverage.text = getString(R.string.vote_format, formattedNumber)
                val vote = detailMovie.voteCount.toString()
                voteCount.text = getString(R.string.vote_count, vote)
                desc.text = detailMovie.overview

                var statusFavorite = detailMovie.isFavorite
                setStatusFavorite(statusFavorite)
                fab.setOnClickListener {
                    statusFavorite = !statusFavorite
                    detailViewModel.setFavoriteMovie(detailMovie, statusFavorite)
                    setStatusFavorite(statusFavorite)
                }
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(context?.let { ContextCompat.getDrawable(it, R.drawable.ic_favorite_white) })
        } else {
            binding.fab.setImageDrawable(context?.let { ContextCompat.getDrawable(it, R.drawable.ic_not_favorite_white) })
        }
    }

}