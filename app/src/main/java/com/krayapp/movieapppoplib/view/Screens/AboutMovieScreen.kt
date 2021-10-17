package com.krayapp.movieapppoplib.view.Screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.krayapp.movieapppoplib.data.MovieInfo
import com.krayapp.movieapppoplib.view.AboutMovieFragment

class AboutMovieScreen(private val movieInfo: MovieInfo):FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        AboutMovieFragment.newInstance(movieInfo)

}