package com.krayapp.movieapppoplib.data

import com.krayapp.movieapppoplib.MovieApp
import com.krayapp.movieapppoplib.data.MovieInfo
import com.krayapp.movieapppoplib.data.retrofit2.DTO.ActorListDTO
import com.krayapp.movieapppoplib.data.retrofit2.DTO.MovieDTO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IMovieRepo {
    fun getPopularMovie(api_key: String, language: String): Single<MovieDTO>

    fun getTopRatedMovie(api_key: String, language: String): Single<MovieDTO>

    fun getUpcomingMovie(api_key: String, language: String): Single<MovieDTO>

    fun loadMovieInfo(id: Int, api_key: String, language: String): Single<MovieInfo>

    fun loadActorList(movieId: Int, api_key: String, language: String): Single<ActorListDTO>
}