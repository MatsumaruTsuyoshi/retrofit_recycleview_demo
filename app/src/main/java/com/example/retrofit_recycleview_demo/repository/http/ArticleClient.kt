package com.example.retrofit_recycleview_demo.repository.http

import com.example.retrofit_recycleview_demo.model.Article
import retrofit2.http.GET

interface ArticleClient {

    @GET("trendTech")
    suspend fun getArticles(): List<Article>
}