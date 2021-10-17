package com.krayapp.movieapppoplib.data.di

import android.content.Context
import android.widget.ImageView
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.krayapp.movieapppoplib.MovieApp
import com.krayapp.movieapppoplib.Schedulers.ISchedulers
import com.krayapp.movieapppoplib.data.imageloader.IImageLoader
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector


@Component(modules = [AndroidInjectionModule::class, MovieRemoteModule::class])
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

        @BindsInstance
        fun withImageLoader(imageLoader:IImageLoader<ImageView>):Builder

        fun build(): ApplicationComponent
    }
}