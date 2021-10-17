package com.krayapp.movieapppoplib.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import com.krayapp.movieapppoplib.data.MovieInfo
import com.krayapp.movieapppoplib.data.imageloader.IImageLoader
import com.krayapp.movieapppoplib.R.layout.list_card_template

class MainScreenAdapter(
    private val delegate:Delegate?,
    private val imageLoader:IImageLoader<ImageView>
    ):ListAdapter<MovieInfo,MainScreenViewHolder>(MainScreenDiff) {
    interface Delegate{
        fun onMoviePicked(movie:MovieInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainScreenViewHolder =
        MainScreenViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(list_card_template,parent,false), imageLoader
        )

    override fun onBindViewHolder(holder: MainScreenViewHolder, position: Int) {
        holder.bind(getItem(position),delegate)
    }
}