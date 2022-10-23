package com.example.androidstudyguide.articlelist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidstudyguide.data.remote.essence.EssenceAPI
import com.example.androidstudyguide.data.repository.ArticleRepository
import com.example.androidstudyguide.databinding.FragmentArticleListBinding
import com.example.androidstudyguide.models.Article
import com.example.androidstudyguide.utils.wrapper.Resources
import com.google.android.material.snackbar.Snackbar

class ArticleListFragment : Fragment(), ArticleClickListener {

    private lateinit var binding: FragmentArticleListBinding
    private lateinit var mAdapter: ArticleListAdapter
    private lateinit var mViewModel: ArticleListViewModel

    private val articleListViewModelFactory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            val articleRepository: ArticleRepository = EssenceArticleRepository(
                api = EssenceAPI.getInstance()
            )
            return ArticleListViewModel(articleRepository = articleRepository) as T
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mAdapter = ArticleListAdapter(
            clickListener = this
        )
        binding = FragmentArticleListBinding.inflate(layoutInflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = ViewModelProvider(
            owner = this,
            factory = articleListViewModelFactory
        )
            .get(ArticleListViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToViewModel()
    }

    override fun onArticleClicked(article: Article) {
        val uri = Uri.parse(article.url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    private fun subscribeToViewModel() {
        mViewModel.articles.observe(viewLifecycleOwner) { articles ->
            when (articles) {
                is Resources.Success -> {
                    articles.data?.let { items ->
                        mAdapter.articles = items
                        binding.fragmentArticleListProgressBar.visibility = View.GONE
                    }
                }

                is Resources.Error -> {
                    Snackbar.make(
                        requireContext(),
                        requireView(),
                        articles.message ?: "shit!",
                        Snackbar.LENGTH_LONG
                    ).show()
                    binding.fragmentArticleListProgressBar.visibility = View.GONE
                }

                is Resources.Loading -> {
                    binding.fragmentArticleListProgressBar.visibility = View.VISIBLE
                }
            }
        }
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
