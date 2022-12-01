package com.example.reddit.data.repository

import com.example.reddit.data.mapper.toRedditList
import com.example.reddit.data.remote.api.RedditApi
import com.example.reddit.domain.model.RedditList
import com.example.reddit.domain.repository.RedditRepository
import com.example.reddit.utils.Resource
import com.example.reddit.utils.SafeApiCall
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RedditRepositoryImpl @Inject constructor(
    private val api: RedditApi,
    private val safeApiCall: SafeApiCall
) : RedditRepository {
    override suspend fun getAllArticle(): Resource<RedditList> = safeApiCall.execute {
        api.getAllArticle().toRedditList()
    }
}