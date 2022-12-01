package com.example.reddit.data.remote.dto


import com.google.gson.annotations.SerializedName

data class RedditListDTO(
    @SerializedName("data")
    val `data`: RedditDTO?,

)

data class RedditDTO(

    @SerializedName("children")
    val children: List<ArticleListDTO>?,

)

data class ArticleListDTO(
    @SerializedName("data")
    val `data`: ArticleDTO?,

)