package com.krayapp.movieapppoplib.view.mvpViews

import com.krayapp.movieapppoplib.data.ActorInfo
import com.krayapp.movieapppoplib.data.MovieInfo
import moxy.MvpView

interface OpenedView:MvpView {
    fun showInfo(movieInfo: MovieInfo)
    fun showActorList(actorList:List<ActorInfo>)
}