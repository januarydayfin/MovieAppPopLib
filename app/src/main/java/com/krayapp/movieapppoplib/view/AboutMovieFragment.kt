package com.krayapp.movieapppoplib.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import com.krayapp.movieapppoplib.view.abs.AbsFragment
import com.krayapp.movieapppoplib.R.layout.*
import com.krayapp.movieapppoplib.Schedulers.ISchedulers
import com.krayapp.movieapppoplib.data.ActorInfo
import com.krayapp.movieapppoplib.data.IMovieRepo
import com.krayapp.movieapppoplib.data.MovieInfo
import com.krayapp.movieapppoplib.data.cache.CacheMovieRepoImpl
import com.krayapp.movieapppoplib.data.imageloader.ImageLoaderImpl
import com.krayapp.movieapppoplib.databinding.AboutMovieBinding
import com.krayapp.movieapppoplib.presentation.AboutMoviePresenter
import com.krayapp.movieapppoplib.view.adapter.ActorListAdapter
import com.krayapp.movieapppoplib.view.mvpViews.AboutView
import moxy.ktx.moxyPresenter
import javax.inject.Inject


class AboutMovieFragment : AbsFragment(about_movie), AboutView {

    companion object {
        private const val ARG_KEY = "ARG_KEY"
        fun newInstance(movieInfo: MovieInfo): Fragment {
            val newFrag = AboutMovieFragment()
            newFrag.arguments = bundleOf(Pair(ARG_KEY, movieInfo))
            return newFrag
        }
    }


    @Inject
    lateinit var schedulers: ISchedulers

    @Inject
    lateinit var movieRepo: IMovieRepo

    @Inject
    lateinit var cacheMovieRepoImpl: CacheMovieRepoImpl

    private val viewBinding: AboutMovieBinding by viewBinding()
    private var actorListAdapter = ActorListAdapter()
    private val presenter by moxyPresenter {
        AboutMoviePresenter(
            arguments?.getParcelable(ARG_KEY)!!,
            movieRepo,
            schedulers,
            cacheMovieRepoImpl
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.actorList.adapter = actorListAdapter
    }

    override fun showInfo(movieInfo: MovieInfo) {
        viewBinding.title.text = movieInfo.title
        viewBinding.description.text = movieInfo.overview
        viewBinding.rate.text = movieInfo.vote_average.toString()
        ImageLoaderImpl().loadInto(movieInfo.poster_path, viewBinding.poster)
    }

    override fun showActorList(actorList: List<ActorInfo>) {
        actorListAdapter.submitList(actorList)
    }

    override fun showErrorToast(text: String) {
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show()
    }
}