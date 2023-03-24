package com.example.retrofit_recycleview_demo.repository

import com.example.retrofit_recycleview_demo.model.Article
import com.example.retrofit_recycleview_demo.repository.http.ArticleClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArticleRepository {

    fun fetchArticle(): Flow<List<Article>> {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://zenn-api.vercel.app/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val client = retrofit.create(ArticleClient::class.java)

        return flow<List<Article>> {
            kotlin.runCatching {
                val dto = client.getArticles()
                emit(dto)
            }.onFailure {
                throw it
            }
        }.flowOn(Dispatchers.IO)
    }
}