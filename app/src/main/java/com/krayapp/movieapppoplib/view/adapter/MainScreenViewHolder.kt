package com.krayapp.movieapppoplib.view.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.movieapppoplib.data.MovieInfo
import com.krayapp.movieapppoplib.data.imageloader.IImageLoader
import com.krayapp.movieapppoplib.databinding.ListCardTemplateBinding

class MainScreenViewHolder(view: View, private val imageloader:IImageLoader<ImageView>):RecyclerView.ViewHolder(view) {

    private val viewBinding:ListCardTemplateBinding by viewBinding()

    fun bind(movieInfo: MovieInfo, delegate:MainScreenAdapter.Delegate?){
        with(viewBinding){
            imageloader.loadInto(movieInfo.poster_path, imageCard)
            titleTemplate.text = movieInfo.title
            descriptionTemplate.text = movieInfo.overview
            rateTemplate.text = movieInfo.vote_average.toString()
            root.setOnClickListener{delegate?.onMoviePicked(movieInfo)}
        }
    }
}