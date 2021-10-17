package com.krayapp.movieapppoplib.view

import androidx.fragment.app.Fragment
import com.krayapp.movieapppoplib.view.abs.AbsFragment
import com.krayapp.movieapppoplib.R.layout.*
import com.krayapp.movieapppoplib.data.MovieInfo
import com.krayapp.movieapppoplib.view.adapter.MainScreenAdapter
import com.krayapp.movieapppoplib.view.mvpViews.MainView


class MainFragment : AbsFragment(main_screen), MainView,MainScreenAdapter.Delegate {

    companion object {
        fun newInstance():Fragment = MainFragment()
    }


    override fun onMoviePicked(movie: MovieInfo) {
        TODO("Not yet implemented")
    }

    override fun showTopRated(list: List<MovieInfo>) {
        TODO("Not yet implemented")
    }

    override fun showPopular(list: List<MovieInfo>) {
        TODO("Not yet implemented")
    }

    override fun showUpcoming(list: List<MovieInfo>) {
        TODO("Not yet implemented")
    }
}