package com.example.reddit.domain.model

data class RedditList(

    val `data`: Reddit?,


    )

data class Reddit(


    val children: List<ArticleList>?,


    ) {
    companion object {
        val empty = Reddit(
            children = emptyList(),

            )
    }
}

data class ArticleList(

    val `data`: Article?,


    )