package com.krayapp.movieapppoplib.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.krayapp.movieapppoplib.data.MovieInfo
import com.krayapp.movieapppoplib.data.retrofit2.DTO.ActorListDTO
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface MovieDAO {
    @Query("SELECT * FROM MovieList")
    fun getFavoriteMoviesCache(): Single<List<MovieInfo>>

    @Query("SELECT * FROM actor_list WHERE movieId = movieId")
    fun getActorList(movieId:Int):Single<List<ActorListDTO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movieInfo: MovieInfo):Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertActorList(actorListDTO: ActorListDTO):Completable
}