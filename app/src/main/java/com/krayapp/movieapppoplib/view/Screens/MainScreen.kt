package com.krayapp.movieapppoplib.view.Screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.krayapp.movieapppoplib.view.MainFragment

object MainScreen:FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment = MainFragment.newInstance()
}