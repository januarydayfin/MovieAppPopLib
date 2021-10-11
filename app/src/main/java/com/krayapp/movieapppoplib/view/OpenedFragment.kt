package com.krayapp.movieapppoplib.view

import com.krayapp.movieapppoplib.view.abs.AbsFragment
import com.krayapp.movieapppoplib.R.layout.*
import com.krayapp.movieapppoplib.data.ActorInfo
import com.krayapp.movieapppoplib.data.MovieInfo
import com.krayapp.movieapppoplib.view.mvpViews.OpenedView


//не забудь добавить делегат из адаптера в будущем
class OpenedFragment:AbsFragment(about_movie),OpenedView {
    override fun showInfo(movieInfo: MovieInfo) {
        TODO("Not yet implemented")
    }

    override fun showActorList(actorList: List<ActorInfo>) {
        TODO("Not yet implemented")
    }
}