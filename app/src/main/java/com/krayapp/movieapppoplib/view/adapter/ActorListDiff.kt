package com.krayapp.movieapppoplib.view.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.krayapp.movieapppoplib.data.ActorInfo

object ActorListDiff : DiffUtil.ItemCallback<ActorInfo>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: ActorInfo, newItem: ActorInfo): Boolean {
        return oldItem.name == newItem.name
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: ActorInfo, newItem: ActorInfo): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: ActorInfo, newItem: ActorInfo): Any =
        payload
}