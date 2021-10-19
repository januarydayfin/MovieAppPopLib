package com.krayapp.movieapppoplib.data.retrofit2.DTO

import androidx.room.*
import com.google.gson.annotations.Expose
import com.krayapp.movieapppoplib.data.ActorInfo
import com.krayapp.movieapppoplib.data.MovieInfo

data class ActorListDTO(
    @Expose
    val id: Int,
    @Expose
    val cast: List<ActorInfo>
)
