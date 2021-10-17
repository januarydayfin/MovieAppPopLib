package com.krayapp.movieapppoplib.view.mvpViews

import com.krayapp.movieapppoplib.data.MovieInfo
import moxy.MvpView

interface MainView:MvpView {
    fun showTopRated(list: List<MovieInfo>)
    fun showPopular(list: List<MovieInfo>)
    fun showUpcoming(list: List<MovieInfo>)
}