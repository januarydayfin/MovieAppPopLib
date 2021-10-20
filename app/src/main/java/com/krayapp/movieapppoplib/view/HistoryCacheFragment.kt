package com.krayapp.movieapppoplib.view

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import com.krayapp.movieapppoplib.view.abs.AbsFragment
import com.krayapp.movieapppoplib.R.layout.history_cache_fragment
import com.krayapp.movieapppoplib.Schedulers.ISchedulers
import com.krayapp.movieapppoplib.data.MovieInfo
import com.krayapp.movieapppoplib.data.cache.CacheMovieRepoImpl
import com.krayapp.movieapppoplib.data.cache.ICacheMovieRepo
import com.krayapp.movieapppoplib.databinding.HistoryCacheFragmentBinding
import com.krayapp.movieapppoplib.presentation.HistoryCachePresenter
import com.krayapp.movieapppoplib.view.adapter.MainScreenAdapter
import com.krayapp.movieapppoplib.view.mvpViews.HistoryCacheView
import moxy.ktx.moxyPresenter
import javax.inject.Inject


class HistoryCacheFragment : AbsFragment(history_cache_fragment), HistoryCacheView, MainScreenAdapter.Delegate {
    companion object {
        fun newInstance() = HistoryCacheFragment()
    }

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var cacheMovieRepoImpl: ICacheMovieRepo

    @Inject
    lateinit var schedulers: ISchedulers

    private val viewBinding:HistoryCacheFragmentBinding by viewBinding()
    private var adapter = MainScreenAdapter(this)
    private val presenter by moxyPresenter { HistoryCachePresenter(cacheMovieRepoImpl, schedulers, router) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.recyclerCache.adapter = adapter
    }
    override fun showCache(movieList: List<MovieInfo>) {
        adapter.submitList(movieList)
    }

    override fun onMoviePicked(movie: MovieInfo) {
        presenter.showMovieInfo(movie)
    }

}