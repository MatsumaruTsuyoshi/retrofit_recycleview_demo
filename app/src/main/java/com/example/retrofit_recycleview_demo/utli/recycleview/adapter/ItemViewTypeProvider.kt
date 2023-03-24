package com.example.retrofit_recycleview_demo.utli.recycleview.adapter

import androidx.databinding.library.baseAdapters.BR
import com.example.retrofit_recycleview_demo.utli.viewmodel.CollectionItemViewModel

interface ItemViewTypeProvider {

    fun getLayoutRes(modelCollectionItem: CollectionItemViewModel): Int

    fun getBindingVariableId(modelCollectionItem: CollectionItemViewModel) = BR.viewModel
}