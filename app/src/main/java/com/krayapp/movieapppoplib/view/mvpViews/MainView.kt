package com.krayapp.movieapppoplib.view.mvpViews

import moxy.MvpView

interface MainView:MvpView {
    fun showTopRated()
    fun showPopular()
    fun showUpcoming()
}