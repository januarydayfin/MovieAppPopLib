package com.krayapp.movieapppoplib

import com.github.terrakok.cicerone.Cicerone
import com.krayapp.movieapppoplib.Schedulers.SimpleShedulers
import com.krayapp.movieapppoplib.data.di.DaggerApplicationComponent
import com.krayapp.movieapppoplib.data.imageloader.ImageLoaderImpl
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MovieApp :DaggerApplication(){

    companion object {
        const val TMDB_API_KEY = "58cb0298f8a3d11c2c5b6afa5a8c7292"
        const val LANGUAGE = "ru-RU"
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()
                withNavigatorHolder(cicerone.getNavigatorHolder())
                withRouter(cicerone.router)
                withSchedulers(SimpleShedulers())
            }
            .build()

}