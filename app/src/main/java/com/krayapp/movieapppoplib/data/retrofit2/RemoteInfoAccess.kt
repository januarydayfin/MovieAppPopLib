package com.krayapp.movieapppoplib.data.retrofit2

import com.krayapp.movieapppoplib.MovieApp
import com.krayapp.movieapppoplib.data.retrofit2.DTO.ActorListDTO
import com.krayapp.movieapppoplib.data.retrofit2.DTO.MovieDTO
import com.krayapp.movieapppoplib.data.MovieInfo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RemoteInfoAccess {
    @GET("movie/popular")
    fun getPopularMovie(
        @Query(MovieApp.TMDB_API_KEY) api_key: String,
        @Query(MovieApp.LANGUAGE) language: String
    ): Single<MovieDTO>

    @GET("movie/top_rated")
    fun getTopRatedMovie(
        @Query(MovieApp.TMDB_API_KEY) api_key: String,
        @Query(MovieApp.LANGUAGE) language: String

    ): Single<MovieDTO>

    @GET("movie/upcoming")
    fun getUpcomingMovie(
        @Query(MovieApp.TMDB_API_KEY) api_key: String,
        @Query(MovieApp.LANGUAGE) language: String
    ): Single<MovieDTO>

    @GET("movie/{id}")
    fun loadMovieInfo(
        @Path("id") id: Int,
        @Query(MovieApp.TMDB_API_KEY) api_key: String,
        @Query(MovieApp.LANGUAGE) language: String
    ): Single<MovieInfo>

    @GET("movie/{movie_id}/credits")
    fun loadActorList(
        @Path("movie_id")movieId:Int,
        @Query(MovieApp.TMDB_API_KEY) api_key: String,
        @Query(MovieApp.LANGUAGE) language: String
    ):Single<ActorListDTO>
}