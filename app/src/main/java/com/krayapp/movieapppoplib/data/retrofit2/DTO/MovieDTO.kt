package com.krayapp.movieapppoplib.data.retrofit2.DTO

import com.google.gson.annotations.Expose
import com.krayapp.movieapppoplib.data.MovieInfo

data class MovieDTO(
    @Expose
    val results: List<MovieInfo>
)
