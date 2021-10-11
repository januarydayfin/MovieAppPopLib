package com.krayapp.movieapppoplib.data

import com.krayapp.movieapppoplib.MovieApp
import com.krayapp.movieapppoplib.data.DTO.ActorListDTO
import com.krayapp.movieapppoplib.data.DTO.MovieDTO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RemoteInfoAccess {
    @GET("3/movie/popular")
    fun getPopularMovie(
        @Query(MovieApp.TMDB_API_KEY) api_key: String,
        @Query(MovieApp.LANGUAGE) language: String
    ): Single<MovieDTO>

    @GET("3/movie/top_rated")
    fun getTopRatedMovie(
        @Query(MovieApp.TMDB_API_KEY) api_key: String,
        @Query(MovieApp.LANGUAGE) language: String

    ): Single<MovieDTO>

    @GET("3/movie/upcoming")
    fun getUpcomingMovie(
        @Query(MovieApp.TMDB_API_KEY) api_key: String,
        @Query(MovieApp.LANGUAGE) language: String
    ): Single<MovieDTO>

    @GET("3/movie/{id}")
    fun loadMovieInfo(
        @Path("id") id: Int,
        @Query(MovieApp.TMDB_API_KEY) api_key: String,
        @Query(MovieApp.LANGUAGE) language: String
    ): Single<MovieInfo>

    @GET("3/movie/{movie_id}/credits")
    fun loadActorList(
        @Path("movie_id")movieId:Int
    ):Single<ActorListDTO>
}