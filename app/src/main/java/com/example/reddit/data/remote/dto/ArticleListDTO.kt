package com.example.reddit.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ArticleDTO(

    @SerializedName("author")
    val author: String?,

    @SerializedName("author_fullname")
    val authorFullname: String?,

    @SerializedName("author_premium")
    val authorPremium: Boolean?,

    @SerializedName("created")
    val created: Double?,
    @SerializedName("created_utc")
    val createdUtc: Double?,

    @SerializedName("id")
    val id: String?,


    @SerializedName("name")
    val name: String?,

    @SerializedName("num_comments")
    val numComments: Int?,


    @SerializedName("selftext")
    val selftext: String?,
    @SerializedName("selftext_html")
    val selftextHtml: String?,

    @SerializedName("subreddit")
    val subreddit: String?,

    @SerializedName("subreddit_id")
    val subredditId: String?,


    @SerializedName("subreddit_type")
    val subredditType: String?,

    @SerializedName("thumbnail")
    val thumbnail: String?,
    @SerializedName("title")
    val title: String?,

    @SerializedName("url")
    val url: String?,


)