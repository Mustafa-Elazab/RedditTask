package com.example.reddit.data.remote.api

import com.example.reddit.data.remote.dto.RedditListDTO
import retrofit2.http.GET

interface RedditApi {


    @GET("kotlin.json")
    suspend fun getAllArticle(): RedditListDTO


}