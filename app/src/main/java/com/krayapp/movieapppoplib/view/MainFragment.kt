package com.krayapp.movieapppoplib.view

import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.ListAdapter
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import com.krayapp.movieapppoplib.R.layout.main_screen
import com.krayapp.movieapppoplib.Schedulers.ISchedulers
import com.krayapp.movieapppoplib.data.IMovieRepo
import com.krayapp.movieapppoplib.data.MovieInfo
import com.krayapp.movieapppoplib.data.imageloader.ImageLoaderImpl
import com.krayapp.movieapppoplib.databinding.MainScreenBinding
import com.krayapp.movieapppoplib.presentation.MainScreenPresenter
import com.krayapp.movieapppoplib.view.abs.AbsFragment
import com.krayapp.movieapppoplib.view.adapter.MainScreenAdapter
import com.krayapp.movieapppoplib.view.mvpViews.MainView
import moxy.ktx.moxyPresenter
import javax.inject.Inject


class MainFragment : AbsFragment(main_screen), MainView, MainScreenAdapter.Delegate {

    companion object {
        fun newInstance(): Fragment = MainFragment()
    }

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var schedulers: ISchedulers

    @Inject
    lateinit var movieRepo: IMovieRepo


    private val presenter by moxyPresenter { MainScreenPresenter(movieRepo, router, schedulers) }
    private val viewBinding: MainScreenBinding by viewBinding()

    private var popularAdapter = MainScreenAdapter(this)
    private var topRatedAdapter = MainScreenAdapter(this)
    private var upcomingAdapter = MainScreenAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.recyclerPopular.adapter = popularAdapter
        viewBinding.recyclerToprated.adapter = topRatedAdapter
        viewBinding.recyclerUpcoming.adapter = upcomingAdapter
    }

    override fun onMoviePicked(movie: MovieInfo) {
        presenter.showMovieInfo(movie)
    }

    override fun showTopRated(list: List<MovieInfo>) {
        topRatedAdapter.submitList(list)
    }

    override fun showPopular(list: List<MovieInfo>) {
        popularAdapter.submitList(list)
    }

    override fun showUpcoming(list: List<MovieInfo>) {
        upcomingAdapter.submitList(list)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewBinding.recyclerPopular.adapter = null
        viewBinding.recyclerToprated.adapter = null
        viewBinding.recyclerUpcoming.adapter = null
    }
}