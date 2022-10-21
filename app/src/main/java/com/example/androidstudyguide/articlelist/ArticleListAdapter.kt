package com.example.androidstudyguide.articlelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidstudyguide.databinding.ItemArticleListBinding
import com.example.androidstudyguide.models.Articles

class ArticleListAdapter : RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder>() {

    var articles: List<Articles> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemArticleListBinding.inflate(inflater, parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.bindArticle(article)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    class ArticleViewHolder(
        private val binding: ItemArticleListBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindArticle(article: Articles) {
            binding.itemArticleListTitle.text = article.title
            binding.itemArticleListAuthor.text = article.authorName
        }
    }
}
