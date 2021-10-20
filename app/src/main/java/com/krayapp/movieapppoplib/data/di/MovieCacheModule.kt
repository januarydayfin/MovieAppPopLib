package com.krayapp.movieapppoplib.data.di

import android.content.Context
import androidx.room.Room
import com.krayapp.movieapppoplib.data.cache.MovieDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MovieCacheModule {
    @Singleton
    @Provides
    fun provideStorage(context: Context):MovieDatabase =
        Room.databaseBuilder(context, MovieDatabase::class.java, "moviedb.db")
            .allowMainThreadQueries()
            .build()
}