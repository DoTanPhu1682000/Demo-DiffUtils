package com.dotanphu.demodiffutils.diff

import androidx.recyclerview.widget.DiffUtil
import com.dotanphu.demodiffutils.model.Movies

class MoviesDiff(private val oldMovies: List<Movies>, private val newMovies: List<Movies>) :
    DiffUtil.Callback() {
    override fun getOldListSize() = oldMovies.size

    override fun getNewListSize() = newMovies.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldMovies[oldItemPosition].id == newMovies[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldMovies[oldItemPosition] == newMovies[newItemPosition]
    }
}