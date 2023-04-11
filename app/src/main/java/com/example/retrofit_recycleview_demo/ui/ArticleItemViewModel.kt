package com.example.retrofit_recycleview_demo.ui

import com.example.retrofit_recycleview_demo.model.Article
import com.example.retrofit_recycleview_demo.utli.viewmodel.CollectionItemViewModel

class ArticleItemViewModel(entity: Article) : CollectionItemViewModel {

    val title: String = entity.title
}