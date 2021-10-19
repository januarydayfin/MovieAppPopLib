package com.krayapp.movieapppoplib.data.di

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.krayapp.movieapppoplib.MovieApp
import com.krayapp.movieapppoplib.Schedulers.ISchedulers
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector


@Component(modules = [AndroidInjectionModule::class, MovieInfoModule::class, MovieRemoteModule::class, MovieCacheModule::class])
interface ApplicationComponent:AndroidInjector<MovieApp> {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withSchedulers(schedulers: ISchedulers): Builder


        fun build(): ApplicationComponent
    }
}