package com.krayapp.movieapppoplib

import com.krayapp.movieapppoplib.data.MovieInfo
import com.krayapp.movieapppoplib.data.retrofit2.DTO.MovieDTO

object MovieListMapper {
    fun map(dto: MovieDTO): List<MovieInfo> = dto.results
}