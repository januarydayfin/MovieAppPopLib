package com.krayapp.movieapppoplib.data.retrofit2.DTO

import com.google.gson.annotations.Expose
import com.krayapp.movieapppoplib.data.ActorInfo

data class ActorListDTO(
    @Expose
    val cast: List<ActorInfo>
)
