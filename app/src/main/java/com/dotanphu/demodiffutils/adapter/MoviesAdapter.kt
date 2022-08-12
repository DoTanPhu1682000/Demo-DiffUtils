package com.dotanphu.demodiffutils.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dotanphu.demodiffutils.databinding.ItemListMoviesBinding
import com.dotanphu.demodiffutils.diff.MoviesDiff
import com.dotanphu.demodiffutils.model.Movies

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ListViewHolder>() {
    //old List
    private val moviesList = arrayListOf<Movies>()

    //new Data
    fun submitData(temp : List<Movies>){
        val diff = MoviesDiff(moviesList,temp)
        val diffResult = DiffUtil.calculateDiff(diff)
        moviesList.clear()
        moviesList.addAll(temp)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            ItemListMoviesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }

    override fun getItemCount() = moviesList.size

    inner class ListViewHolder(private val binding: ItemListMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: Movies) {
            binding.tvTitle.text = movies.title
            binding.tvReleaseDateDetail.text = movies.releaseDate
            binding.tvRatingDetail.text = movies.rating.toString()
            binding.tvOverviewDetail.text = movies.overView
        }
    }
}