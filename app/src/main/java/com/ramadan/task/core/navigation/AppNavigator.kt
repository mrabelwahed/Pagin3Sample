package com.ramadan.task.core.navigation

import androidx.fragment.app.FragmentActivity
import com.ramadan.task.R
import com.ramadan.task.ui.fragments.CharacterDetailsFragment
import com.ramadan.task.ui.fragments.CharactersListFragment
import javax.inject.Inject

class AppNavigator @Inject constructor(private val activity: FragmentActivity): Navigator {

    override fun navigateTo(screen: Screen) {
       val fragment = when(screen){
           Screen.CHARACTERS_LIST -> CharactersListFragment()
           Screen.CHARACTER_DETAILS -> CharacterDetailsFragment()
       }
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.container , fragment)
            .addToBackStack(fragment.javaClass.canonicalName)
            .commit()
    }
}