package com.example.reddit.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.reddit.R
import com.example.reddit.databinding.RedditItemBinding
import com.example.reddit.domain.model.ArticleList
import com.example.reddit.view.fragment.home.HomeFragmentDirections


class ArticleAdapter : ListAdapter<ArticleList, ArticleAdapter.ViewHolder>(DIFF_CALLBACK) {

    inner class ViewHolder(var view: RedditItemBinding) : RecyclerView.ViewHolder(view.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.reddit_item,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {





        holder.view.apply {
            article = getItem(position).data
        }
        holder.view.root.setOnClickListener {

            val action =
                HomeFragmentDirections.actionHomeFragmentToDetailFragment(article = getItem(position).data!!)
            Navigation.findNavController(it).navigate(action)

        }

    }


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ArticleList>() {
            override fun areItemsTheSame(oldItem: ArticleList, newItem: ArticleList): Boolean {
                return false
            }

            override fun areContentsTheSame(oldItem: ArticleList, newItem: ArticleList): Boolean {
                return false
            }
        }
    }


}