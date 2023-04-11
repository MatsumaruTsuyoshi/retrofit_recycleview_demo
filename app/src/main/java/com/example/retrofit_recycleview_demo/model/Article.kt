package com.example.retrofit_recycleview_demo.model

const val DOMAIN = "https://zenn.dev"

data class Article(
    val title: String,
    val path: String,

    ) {

    fun getUrl(): String {
        return DOMAIN + path
    }
}