package com.example.androidstudyguide.articlelist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidstudyguide.R
import com.example.androidstudyguide.databinding.FragmentArticleListBinding
import com.example.androidstudyguide.models.Article
import com.example.androidstudyguide.utils.extensions.visibleIf
import com.example.androidstudyguide.utils.wrapper.ViewState
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleListFragment : Fragment(), ArticleClickListener {

    private lateinit var binding: FragmentArticleListBinding
    private lateinit var mAdapter: ArticleListAdapter

    private val mViewModel: ArticleListViewModel by viewModels()

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToViewModel()
    }

    override fun onArticleClicked(article: Article) {
        val uri = Uri.parse(article.url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    override fun onArticleBookmarkClicked(article: Article, position: Int) {
        val item = mViewModel.bookmarkClicked(article)
        mAdapter.notifyItemChanged(position, item)
    }

    private fun subscribeToViewModel() {
        mViewModel.state.observe(viewLifecycleOwner) { viewState ->
            binding.fragmentArticleListProgressBar.visibleIf(viewState is ViewState.Loading)
            binding.fragmentArticleListRecycler.visibleIf(viewState is ViewState.Success)

            if (viewState is ViewState.Success) {
                mAdapter.articles = viewState.articles
            }

            if (viewState is ViewState.Error) {
                Snackbar.make(
                    requireContext(),
                    requireView(),
                    viewState.error.message ?: "Something went wrong!",
                    Snackbar.LENGTH_INDEFINITE
                )
                    .setAction("Retry") {
                        mViewModel.retryFetch()
                    }
                    .setActionTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                    .setBackgroundTint(ContextCompat.getColor(requireContext(), android.R.color.holo_red_dark))
                    .show()
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
