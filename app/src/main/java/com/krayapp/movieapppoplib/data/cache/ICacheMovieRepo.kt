package com.krayapp.movieapppoplib.data.cache

import com.krayapp.movieapppoplib.data.MovieInfo
import com.krayapp.movieapppoplib.data.retrofit2.DTO.ActorListDTO
import io.reactivex.Completable
import io.reactivex.Single

interface ICacheMovieRepo {
    fun getFavoriteMoviesCache(): Single<List<MovieInfo>>
    fun insertMovie(movieInfo: MovieInfo)
}