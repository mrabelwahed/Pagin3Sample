package com.ramadan.task.data.api

import com.ramadan.task.data.response.Character
import com.ramadan.task.data.response.PagedResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterAPI {
    @GET("api/character")
    suspend fun getCharacters(@Query("page") page:Int) : Response<PagedResponse<Character>>
}