package com.krayapp.movieapppoplib.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.krayapp.movieapppoplib.data.MovieInfo
import com.krayapp.movieapppoplib.R.layout.movie_card_template

class MainScreenAdapter(
    private val delegate:Delegate?
    ):ListAdapter<MovieInfo,MainScreenViewHolder>(MainScreenDiff) {
    interface Delegate{
        fun onMoviePicked(movie:MovieInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainScreenViewHolder =
        MainScreenViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(movie_card_template,parent,false)
        )

    override fun onBindViewHolder(holder: MainScreenViewHolder, position: Int) {
        holder.bind(getItem(position),delegate)
    }
}