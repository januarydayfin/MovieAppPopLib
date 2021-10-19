package com.krayapp.movieapppoplib.data.di

import com.krayapp.movieapppoplib.MainActivity
import com.krayapp.movieapppoplib.data.IMovieRepo
import com.krayapp.movieapppoplib.data.cache.CacheMovieRepoImpl
import com.krayapp.movieapppoplib.data.cache.ICacheMovieRepo
import com.krayapp.movieapppoplib.data.retrofit2.MovieRepoImpl
import com.krayapp.movieapppoplib.view.AboutMovieFragment
import com.krayapp.movieapppoplib.view.MainFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MovieInfoModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindMovieFragment(): MainFragment

    @ContributesAndroidInjector
    fun bindAboutMovieFragment(): AboutMovieFragment

    @Binds
    fun bindMovieRepo(movieRepo:MovieRepoImpl):IMovieRepo

    @Binds
    fun bindCacheMovie(cacheMovieRepoImpl: CacheMovieRepoImpl):ICacheMovieRepo

}