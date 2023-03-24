package com.example.retrofit_recycleview_demo.ui

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_recycleview_demo.repository.ArticleRepository
import com.example.retrofit_recycleview_demo.utli.viewmodel.CollectionItemViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach

class MainViewModel : ViewModel() {

    val viewModels = ObservableArrayList<CollectionItemViewModel>()

    init {
        fetchList()
    }

    private fun fetchList() {
        ArticleRepository().fetchArticle().onEach {
            val articles = it.map { ArticleItemViewModel(it) }
            viewModels.addAll(articles)
        }.catch { cause ->
            // エラー処理
            throw cause
        }.onCompletion {
            // after completion
        }.launchIn(viewModelScope)
    }
}