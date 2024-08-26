package com.cindy.movieapp.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cindy.movieapp.core.R
import com.cindy.movieapp.core.databinding.ItemListMovieBinding
import com.cindy.movieapp.core.domain.model.Movie

class MovieAdapter (private val onItemClick: (Movie) -> Unit) : ListAdapter<Movie, MovieAdapter.MyViewHolder>(
    DIFF_CALLBACK
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemListMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            onItemClick(movie)
        }
    }

    class MyViewHolder(private val binding: ItemListMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie){
            with(binding){
                Glide.with(itemView.context)
                    .load(itemView.context.getString(R.string.baseUrlImage, movie.posterPath))
                    .into(imgPoster)
                tvTitle.text = movie.title
                val releaseyear = movie.releaseDate.take(4)
                val language = movie.originalLanguage.uppercase()
                languagenyear.text = itemView.context.getString(R.string.language_release_year, language, releaseyear)
                val formattedNumber = String.format("%.2f", movie.voteAverage)
                voteAverage.text = itemView.context.getString(R.string.vote_format, formattedNumber)
                val votecount = movie.voteCount.toString()
                voteCount.text = itemView.context.getString(R.string.vote_count, votecount)
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }

}