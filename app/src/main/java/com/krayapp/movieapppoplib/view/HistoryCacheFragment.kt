package com.krayapp.movieapppoplib.view

import com.krayapp.movieapppoplib.view.abs.AbsFragment
import com.krayapp.movieapppoplib.R.layout.history_cache_fragment
import com.krayapp.movieapppoplib.view.mvpViews.HistoryCacheView


class HistoryCacheFragment : AbsFragment(history_cache_fragment), HistoryCacheView {
    companion object {
        fun newInstance() = HistoryCacheFragment()
    }

    override fun showCache() {
        TODO("Not yet implemented")
    }
}