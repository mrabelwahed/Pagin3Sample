package com.ramadan.task.data.response

data class PagedResponse<T>(
    val info: Info,
    val results: List<T>
)