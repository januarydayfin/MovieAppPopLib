package com.krayapp.movieapppoplib.view.mvpViews

import com.krayapp.movieapppoplib.data.MovieInfo
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface HistoryCacheView:MvpView {
    fun showCache(movieList: List<MovieInfo>)
}