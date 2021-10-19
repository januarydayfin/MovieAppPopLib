package com.krayapp.movieapppoplib.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.krayapp.movieapppoplib.data.MovieInfo
import com.krayapp.movieapppoplib.data.retrofit2.DTO.ActorListDTO


@Database(
    exportSchema = false,
    entities = [MovieInfo::class],
    version = 1
)
abstract class MovieDatabase:RoomDatabase() {
    abstract val movieDAO:MovieDAO
}