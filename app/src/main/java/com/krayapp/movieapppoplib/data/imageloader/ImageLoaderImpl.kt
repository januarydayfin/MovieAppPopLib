package com.krayapp.movieapppoplib.data.imageloader

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.krayapp.movieapppoplib.R
import com.squareup.picasso.Picasso
import javax.inject.Inject

class ImageLoaderImpl {

    fun loadInto(url: String, container: ImageView) {
        val currentUrl = "https://image.tmdb.org/t/p/w500/${url}"
        Picasso
            .get()
            .load(currentUrl)
            .into(container)
    }
}