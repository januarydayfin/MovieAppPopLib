package com.krayapp.movieapppoplib.presentation

import com.krayapp.movieapppoplib.Mapper
import com.krayapp.movieapppoplib.MovieApp
import com.krayapp.movieapppoplib.Schedulers.ISchedulers
import com.krayapp.movieapppoplib.data.IMovieRepo
import com.krayapp.movieapppoplib.data.MovieInfo
import com.krayapp.movieapppoplib.view.mvpViews.AboutView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import moxy.MvpPresenter

class AboutMoviePresenter(
    private val movie:MovieInfo,
    private val movieRepo: IMovieRepo,
    private val schedulers: ISchedulers
):MvpPresenter<AboutView>(){
    private var disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadActorList()
    }

    private fun loadActorList(){
        viewState.showInfo(movie)
        movieRepo
            .loadActorList(movie.id, MovieApp.TMDB_API_KEY, MovieApp.LANGUAGE)
            .map (Mapper::mapActorList)
            .observeOn(schedulers.main())
            .subscribeOn(schedulers.io())
            .subscribe(viewState::showActorList){
                println(Throwable("Error in Load Actor Stream"))
            }
            .addTo(disposables)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}