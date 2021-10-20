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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movieInfo: MovieInfo)

    @Query("DELETE FROM MovieList")
    fun cleanTable()

}