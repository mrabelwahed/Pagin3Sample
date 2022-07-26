package com.ramadan.task.ui.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ramadan.task.data.RepositoryImpl
import com.ramadan.task.data.response.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor( private val repository: RepositoryImpl) : BaseViewModel() {
    private lateinit var _charactersFlow : Flow<PagingData<Character>>
     val charactersFlow : Flow<PagingData<Character>>
    get() = _charactersFlow

    init {
        getAllCharacters()
    }

    private fun getAllCharacters() =
        launchPagingAsync({ repository.getCharacters().cachedIn(viewModelScope) }, {
            _charactersFlow = it
        }
        )
}