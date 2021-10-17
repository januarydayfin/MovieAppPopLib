package com.krayapp.movieapppoplib.view

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.krayapp.movieapppoplib.view.abs.AbsFragment
import com.krayapp.movieapppoplib.R.layout.*
import com.krayapp.movieapppoplib.data.ActorInfo
import com.krayapp.movieapppoplib.data.MovieInfo
import com.krayapp.movieapppoplib.view.mvpViews.OpenedView


class AboutMovieFragment:AbsFragment(about_movie),OpenedView {

    companion object{
        private const val ARG_KEY = "ARG_KEY"
        fun newInstance(movieInfo: MovieInfo): Fragment {
            val newFrag = AboutMovieFragment()
            newFrag.arguments = bundleOf(Pair(ARG_KEY, movieInfo))
            return newFrag
        }

    }
    override fun showInfo(movieInfo: MovieInfo) {
        TODO("Not yet implemented")
    }

    override fun showActorList(actorList: List<ActorInfo>) {
        TODO("Not yet implemented")
    }
}