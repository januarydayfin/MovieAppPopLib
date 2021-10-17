package com.krayapp.movieapppoplib.view.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.krayapp.movieapppoplib.data.MovieInfo

object MainScreenDiff: DiffUtil.ItemCallback<MovieInfo>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: MovieInfo, newItem: MovieInfo): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: MovieInfo, newItem: MovieInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun getChangePayload(oldItem: MovieInfo, newItem: MovieInfo): Any = payload
}