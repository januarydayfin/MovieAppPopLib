package com.krayapp.movieapppoplib

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.krayapp.movieapppoplib.view.Screens.MainScreen
import com.krayapp.movieapppoplib.view.abs.AbsActivity
import javax.inject.Inject

class MainActivity : AbsActivity() {

    private val navigator = AppNavigator(this, R.id.content)


    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: router.newRootScreen(MainScreen)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }
}