package com.krayapp.movieapppoplib


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.krayapp.movieapppoplib.view.Screens.MainScreen
import com.krayapp.movieapppoplib.view.abs.AbsActivity
import com.krayapp.movieapppoplib.R.menu.*
import com.krayapp.movieapppoplib.view.Screens.HistoryCacheScreen
import javax.inject.Inject

class MainActivity : AbsActivity() {

    private val navigator = AppNavigator(this, android.R.id.content)


    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(main_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.movie_history ->{
                router.navigateTo(HistoryCacheScreen)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: router.newRootScreen(MainScreen)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }
}