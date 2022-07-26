package com.ramadan.task.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ramadan.task.R
import com.ramadan.task.core.navigation.AppNavigator
import com.ramadan.task.core.navigation.Screen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var appNavigator: AppNavigator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null)
            appNavigator.navigateTo(Screen.CHARACTERS_LIST)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount == 0)
            finish()
    }
}