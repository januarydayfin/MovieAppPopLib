package com.krayapp.movieapppoplib.view.mvpViews

import com.krayapp.movieapppoplib.data.ActorInfo
import com.krayapp.movieapppoplib.data.MovieInfo
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface AboutView:MvpView {
    fun showInfo(movieInfo: MovieInfo)
    fun showActorList(actorList:List<ActorInfo>)
    fun showErrorToast(text:String)
}