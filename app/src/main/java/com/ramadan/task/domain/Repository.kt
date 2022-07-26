package com.ramadan.task.domain

import androidx.paging.PagingData
import com.ramadan.task.data.response.Character
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getCharacters(): Flow<PagingData<Character>>
}