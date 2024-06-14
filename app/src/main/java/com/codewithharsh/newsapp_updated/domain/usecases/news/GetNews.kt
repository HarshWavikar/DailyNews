package com.codewithharsh.newsapp_updated.domain.usecases.news

import androidx.paging.PagingData
import com.codewithharsh.newsapp_updated.domain.model.Article
import com.codewithharsh.newsapp_updated.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val repository: NewsRepository
) {
     operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return repository.getNews(sources)
    }
}