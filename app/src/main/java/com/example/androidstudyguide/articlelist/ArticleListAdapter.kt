package com.example.androidstudyguide.articlelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidstudyguide.R
import com.example.androidstudyguide.databinding.ItemArticleListBinding
import com.example.androidstudyguide.models.Article

class ArticleListAdapter(
    private val clickListener: ArticleClickListener
) : RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder>() {

    var articles: List<Article> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemArticleListBinding.inflate(inflater, parent, false)
        return ArticleViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.bindArticle(article)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    class ArticleViewHolder(
        private val binding: ItemArticleListBinding,
        private val clickListener: ArticleClickListener
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindArticle(article: Article) {
            binding.itemArticleListTitle.text = article.title.getEncodedString()
            binding.itemArticleListAuthor.text = itemView.context.getString(
                R.string.author_name,
                article.authorName
            )

            itemView.setOnClickListener {
                clickListener.onArticleClicked(article)
            }
        }
    }
}
