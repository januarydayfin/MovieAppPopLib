package com.krayapp.movieapppoplib.presentation

import com.github.terrakok.cicerone.Router
import com.krayapp.movieapppoplib.Schedulers.ISchedulers
import com.krayapp.movieapppoplib.data.MovieInfo
import com.krayapp.movieapppoplib.data.cache.ICacheMovieRepo
import com.krayapp.movieapppoplib.view.Screens.AboutMovieScreen
import com.krayapp.movieapppoplib.view.mvpViews.HistoryCacheView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import moxy.MvpPresenter

class HistoryCachePresenter(
    private val localRepo:ICacheMovieRepo,
    private val schedulers: ISchedulers,
    private val router: Router
):MvpPresenter<HistoryCacheView>() {

    private var disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadCache()
    }

    private fun loadCache(){
        localRepo
            .getFavoriteMoviesCache()
            .observeOn(schedulers.main())
            .subscribeOn(schedulers.io())
            .subscribe(viewState::showCache)
            .addTo(disposables)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
    fun showMovieInfo(movie:MovieInfo){
        router.navigateTo(AboutMovieScreen(movie))
    }
}