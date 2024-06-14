package com.codewithharsh.newsapp_updated.data.remote

import com.codewithharsh.newsapp_updated.core.Constants.API_KEY
import com.codewithharsh.newsapp_updated.data.remote.dto.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse
}