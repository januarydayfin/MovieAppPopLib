package com.krayapp.movieapppoplib.data.retrofit2

import com.krayapp.movieapppoplib.MovieApp
import com.krayapp.movieapppoplib.data.IMovieRepo
import com.krayapp.movieapppoplib.data.MovieInfo
import com.krayapp.movieapppoplib.data.retrofit2.DTO.ActorListDTO
import com.krayapp.movieapppoplib.data.retrofit2.DTO.MovieDTO
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieRepoImpl
    @Inject constructor(
    private val api: RemoteInfoAccess
) : IMovieRepo {
    override fun getPopularMovie(api_key: String, language: String): Single<MovieDTO> =
        api.getPopularMovie(api_key, language)

    override fun getTopRatedMovie(api_key: String, language: String): Single<MovieDTO> =
        api.getTopRatedMovie(api_key, language)

    override fun getUpcomingMovie(api_key: String, language: String): Single<MovieDTO> =
        api.getUpcomingMovie(api_key, language)

    override fun loadMovieInfo(id: Int, api_key: String, language: String): Single<MovieInfo> =
        api.loadMovieInfo(id, api_key, language)

    override fun loadActorList(
        movieId: Int,
        api_key: String,
        language: String
    ): Single<ActorListDTO> =
        api.loadActorList(movieId, api_key, language)

}