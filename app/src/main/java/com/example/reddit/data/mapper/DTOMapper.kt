package com.example.reddit.data.mapper

import com.example.reddit.data.remote.dto.ArticleDTO
import com.example.reddit.data.remote.dto.ArticleListDTO
import com.example.reddit.data.remote.dto.RedditDTO
import com.example.reddit.data.remote.dto.RedditListDTO
import com.example.reddit.domain.model.Article
import com.example.reddit.domain.model.ArticleList
import com.example.reddit.domain.model.Reddit
import com.example.reddit.domain.model.RedditList

fun RedditListDTO.toRedditList() = RedditList(data = data?.toReddit())

fun RedditDTO.toReddit() = Reddit(children?.map {
    it.toArticleList()
})

fun ArticleListDTO.toArticleList() = ArticleList(data?.toArticle())

fun ArticleDTO.toArticle() = Article(
    author,
    authorPremium,
    created,
    createdUtc,
    id,
    name,
    numComments,
    selftext,
    selftextHtml,
    subreddit,
    subredditId,
    subredditType,
    thumbnail,
    title,
    url,

)