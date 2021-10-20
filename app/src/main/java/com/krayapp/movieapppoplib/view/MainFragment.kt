package com.krayapp.movieapppoplib.view

import com.krayapp.movieapppoplib.view.abs.AbsFragment
import com.krayapp.movieapppoplib.R.layout.*
import com.krayapp.movieapppoplib.view.mvpViews.MainView


//не забудь добавить делегат из адаптера в будущем
class MainFragment:AbsFragment(main_screen), MainView {
    override fun showTopRated() {
        TODO("Not yet implemented")
    }

    override fun showPopular() {
        TODO("Not yet implemented")
    }

    override fun showUpcoming() {
        TODO("Not yet implemented")
    }
}