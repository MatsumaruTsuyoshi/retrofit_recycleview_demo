package com.example.retrofit_recycleview_demo.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit_recycleview_demo.R
import com.example.retrofit_recycleview_demo.databinding.MainFragmentBinding
import com.example.retrofit_recycleview_demo.utli.recycleview.adapter.ItemViewTypeProvider
import com.example.retrofit_recycleview_demo.utli.recycleview.adapter.RecyclerViewAdapter
import com.example.retrofit_recycleview_demo.utli.viewmodel.CollectionItemViewModel

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {

        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = MainFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.viewModel = viewModel
        (activity as? AppCompatActivity)?.supportActionBar?.title = "RecyclerView Sample"

        val itemViewTypeProvider = object : ItemViewTypeProvider {
            override fun getLayoutRes(modelCollectionItem: CollectionItemViewModel): Int {
                return when (modelCollectionItem) {
                    is ArticleItemViewModel -> R.layout.list_item_main_content
                    else -> throw IllegalArgumentException("Unexpected layout")
                }
            }
        }

        binding.recyclerView.adapter = RecyclerViewAdapter(viewModel.viewModels, itemViewTypeProvider)

    }
}