package com.example.reddit.domain.repository

import com.example.reddit.domain.model.RedditList
import com.example.reddit.utils.Resource

interface RedditRepository {

    suspend fun getAllArticle () : Resource<RedditList>
}