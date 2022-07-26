package com.ramadan.task.core.navigation

interface Navigator {
    fun navigateTo(screen : Screen)
}

enum class Screen{
    CHARACTERS_LIST , CHARACTER_DETAILS
}