package com.krayapp.movieapppoplib.presentation

import com.github.terrakok.cicerone.Router
import com.krayapp.movieapppoplib.MovieApp
import com.krayapp.movieapppoplib.MovieListMapper
import com.krayapp.movieapppoplib.Schedulers.ISchedulers
import com.krayapp.movieapppoplib.data.IMovieRepo
import com.krayapp.movieapppoplib.view.mvpViews.MainView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import moxy.MvpPresenter

class MainScreenPresenter(
    private val movieRepo: IMovieRepo,
    private val router: Router,
    private val schedulers: ISchedulers
) : MvpPresenter<MainView>() {
    private var disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadPopular()
        loadTopRated()
        loadUpcoming()
    }

    fun loadPopular() =
        movieRepo
            .getPopularMovie(MovieApp.TMDB_API_KEY, MovieApp.LANGUAGE)
            .map(MovieListMapper::map)
            .observeOn(schedulers.main())
            .subscribeOn(schedulers.io())
            .subscribe(viewState::showPopular) {
                println(Throwable("Error in Data Stream"))
            }
            .addTo(disposables)

    fun loadTopRated() =
        movieRepo
            .getTopRatedMovie(MovieApp.TMDB_API_KEY, MovieApp.LANGUAGE)
            .map(MovieListMapper::map)
            .observeOn(schedulers.main())
            .subscribeOn(schedulers.io())
            .subscribe(viewState::showTopRated) {
                println(Throwable("Error in Data Stream"))
            }
            .addTo(disposables)

    fun loadUpcoming() =
        movieRepo
            .getUpcomingMovie(MovieApp.TMDB_API_KEY, MovieApp.LANGUAGE)
            .map(MovieListMapper::map)
            .observeOn(schedulers.main())
            .subscribeOn(schedulers.io())
            .subscribe(viewState::showUpcoming) {
                println(Throwable("Error in Data Stream"))
            }
            .addTo(disposables)
}