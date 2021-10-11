package com.krayapp.movieapppoplib.data.DTO

import com.google.gson.annotations.Expose

data class ActorListDTO(
    @Expose
    val cast: List<ActorInfo>
)
