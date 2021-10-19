package com.krayapp.movieapppoplib.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.movieapppoplib.data.MovieInfo
import com.krayapp.movieapppoplib.data.imageloader.ImageLoaderImpl
import com.krayapp.movieapppoplib.databinding.MovieCardTemplateBinding

class MainScreenViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val viewBinding:MovieCardTemplateBinding by viewBinding()

    fun bind(movieInfo: MovieInfo, delegate:MainScreenAdapter.Delegate?){
        with(viewBinding){
            ImageLoaderImpl()
                .loadInto(movieInfo.poster_path, imageCard)
            titleTemplate.text = movieInfo.title
            descriptionTemplate.text = movieInfo.overview
            rateTemplate.text = movieInfo.vote_average.toString()
            root.setOnClickListener{delegate?.onMoviePicked(movieInfo)}
        }
    }
}