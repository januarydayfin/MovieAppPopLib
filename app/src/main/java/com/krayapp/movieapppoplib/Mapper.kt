package com.krayapp.movieapppoplib

import com.krayapp.movieapppoplib.data.ActorInfo
import com.krayapp.movieapppoplib.data.MovieInfo
import com.krayapp.movieapppoplib.data.retrofit2.DTO.ActorListDTO
import com.krayapp.movieapppoplib.data.retrofit2.DTO.MovieDTO

object Mapper {
    fun mapMovieList(dto: MovieDTO): List<MovieInfo> = dto.results
    fun mapActorList(dto:ActorListDTO):List<ActorInfo> = dto.cast
}