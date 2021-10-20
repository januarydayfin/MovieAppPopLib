package com.krayapp.movieapppoplib.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.movieapppoplib.data.ActorInfo
import com.krayapp.movieapppoplib.databinding.CastTemplateBinding

class ActorListViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val viewBinding:CastTemplateBinding by viewBinding()

    fun bind(actorInfo:ActorInfo){
        with(viewBinding){
            actorName.text = actorInfo.name
        }
    }
}