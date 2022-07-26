package com.ramadan.task.data.paging

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ramadan.task.data.api.CharacterAPI
import com.ramadan.task.data.response.Character

class CharacterPagingSource (private val api:CharacterAPI): PagingSource<Int, Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int?  = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
      val pageNumber = params.key ?: 1

        return  try {
            val response =  api.getCharacters(pageNumber)
            val body = response.body()
            val data = body?.results
            var nextPageNumber : Int? = null
            if(body?.info?.next != null){
               val next =  body?.info.next
                val uri = Uri.parse(next)
                nextPageNumber =  uri.getQueryParameter("page")?.toInt()
            }
            LoadResult.Page(
                data = data.orEmpty(),
                prevKey = null,
                nextKey = nextPageNumber
            )
        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }
}