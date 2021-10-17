package com.krayapp.movieapppoplib.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.krayapp.movieapppoplib.data.ActorInfo
import com.krayapp.movieapppoplib.R.layout.cast_template


class ActorListAdapter : ListAdapter<ActorInfo, ActorListViewHolder>(ActorListDiff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorListViewHolder =
        ActorListViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(cast_template, parent, false)
        )

    override fun onBindViewHolder(holder: ActorListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}