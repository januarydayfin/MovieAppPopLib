package com.krayapp.movieapppoplib.data

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieInfo(
    @Expose
    val id: Int,
    @Expose
    val title: String,
    @Expose
    val overview: String,
    @Expose
    val vote_average: Float,
    @Expose
    val poster_path: String,
) : Parcelable
