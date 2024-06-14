package com.codewithharsh.newsapp_updated.domain.repository

import androidx.paging.PagingData
import com.codewithharsh.newsapp_updated.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources: List<String>): Flow<PagingData<Article>>
}