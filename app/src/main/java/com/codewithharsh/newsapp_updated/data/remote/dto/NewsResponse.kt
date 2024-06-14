package com.codewithharsh.newsapp_updated.data.remote.dto

import com.codewithharsh.newsapp_updated.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)

