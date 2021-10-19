package com.krayapp.movieapppoplib.data.cache

import com.krayapp.movieapppoplib.data.MovieInfo
import com.krayapp.movieapppoplib.data.retrofit2.DTO.ActorListDTO
import io.reactivex.Single
import javax.inject.Inject

class CacheMovieRepoImpl
@Inject constructor(
    private val database: MovieDatabase
) : ICacheMovieRepo {
    override fun getFavoriteMoviesCache(): Single<List<MovieInfo>> =
        database
            .movieDAO
            .getFavoriteMoviesCache()


    override fun insertMovie(movieInfo: MovieInfo) =
        database.movieDAO.insertMovie(movieInfo)

}
