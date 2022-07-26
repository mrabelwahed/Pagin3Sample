package com.ramadan.task.data

import androidx.paging.Config
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ramadan.task.core.common.AppConst.PAGE_SIZE
import com.ramadan.task.data.api.CharacterAPI
import com.ramadan.task.data.paging.CharacterPagingSource
import com.ramadan.task.data.response.Character
import com.ramadan.task.domain.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val api:CharacterAPI) : Repository {
    override suspend fun getCharacters(): Flow<PagingData<Character>> {
       return  Pager(
           config = PagingConfig( pageSize = PAGE_SIZE , prefetchDistance = 2),
           pagingSourceFactory = {CharacterPagingSource(api)}
       ).flow
    }
}