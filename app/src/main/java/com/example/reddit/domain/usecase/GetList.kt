package com.example.reddit.domain.usecase

import com.example.reddit.domain.repository.RedditRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetList @Inject constructor(private val repository: RedditRepository) {

    operator fun invoke() = flow {
        emit(repository.getAllArticle())
    }
}