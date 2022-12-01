package com.example.reddit.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Article(


    val author: String?,


    val authorPremium: Boolean?,


    val created: Double?,

    val createdUtc: Double?,


    val id: String?,


    val name: String?,


    val numComments: Int?,


    val selftext: String?,

    val selftextHtml: String?,


    val subreddit: String?,


    val subredditId: String?,


    val subredditType: String?,


    val thumbnail: String?,

    val title: String?,


    val url: String?,


    ) : Parcelable