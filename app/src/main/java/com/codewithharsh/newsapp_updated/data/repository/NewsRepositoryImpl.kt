package com.codewithharsh.newsapp_updated.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.codewithharsh.newsapp_updated.data.remote.NewsApi
import com.codewithharsh.newsapp_updated.data.remote.NewsPagingSource
import com.codewithharsh.newsapp_updated.domain.model.Article
import com.codewithharsh.newsapp_updated.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow


class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}