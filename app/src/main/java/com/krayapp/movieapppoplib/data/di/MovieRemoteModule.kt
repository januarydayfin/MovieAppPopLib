package com.krayapp.movieapppoplib.data.di

import com.google.gson.GsonBuilder
import com.krayapp.movieapppoplib.data.retrofit2.RemoteInfoAccess
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class MovieRemoteModule {
    @Reusable
    @Provides
    fun getFromAPI(): RemoteInfoAccess =
        Retrofit.Builder()
            .baseUrl("https://api.tmdb.org/3/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setLenient().create()
                )
            )
            .build()
            .create(RemoteInfoAccess::class.java)
}