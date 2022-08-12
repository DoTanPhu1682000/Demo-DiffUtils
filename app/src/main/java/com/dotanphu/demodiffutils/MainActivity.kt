package com.dotanphu.demodiffutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dotanphu.demodiffutils.adapter.MoviesAdapter
import com.dotanphu.demodiffutils.databinding.ActivityMainBinding
import com.dotanphu.demodiffutils.model.Movies

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MoviesAdapter
    private val moviesList = arrayListOf(
        Movies(1, "Thor", "12/1/2022", 7.5, "very good", ""),
        Movies(2, "Minions", "3/12/2012", 8.5, "very good", ""),
        Movies(3, "Lucky", "6/6/2021", 9.5, "very good", ""),
        Movies(3, "Lucky", "6/6/2021", 9.5, "very good", ""),
        Movies(3, "Lucky", "6/6/2021", 9.5, "very good", ""),
        Movies(3, "Lucky", "6/6/2021", 9.5, "very good", ""),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRV()
        swipeToRemove()
    }

    private fun swipeToRemove() {
        val callback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.START or ItemTouchHelper.END
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                moviesList.removeAt(position)
                adapter.submitData(moviesList)
            }
        }
        ItemTouchHelper(callback).attachToRecyclerView(binding.rvMovies)
    }

    private fun setupRV() {
        adapter = MoviesAdapter()
        adapter.submitData(moviesList)
        binding.rvMovies.adapter = adapter
        binding.rvMovies.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

}