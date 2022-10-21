package com.example.androidstudyguide.articlelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidstudyguide.data.repository.ArticleRepository
import com.example.androidstudyguide.databinding.FragmentArticleListBinding

class ArticleListFragment : Fragment() {

    private lateinit var binding: FragmentArticleListBinding
    private lateinit var mAdapter: ArticleListAdapter

    private val articleRepository: ArticleRepository = ArticleListRepositoryImp()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mAdapter = ArticleListAdapter()
        binding = FragmentArticleListBinding.inflate(layoutInflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter.articles = articleRepository.getArticles()
    }

    private fun setupRecyclerView() {
        val itemDivider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.fragmentArticleListRecycler.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(itemDivider)
        }
    }
}
