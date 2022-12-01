package com.example.reddit.utils

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import java.text.ParseException
import java.text.SimpleDateFormat

@BindingAdapter("isVisible")
fun View.setVisibility(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}


@BindingAdapter("loadImage")
fun ImageView.loadImage(imageUrl: String?) {
    imageUrl?.let {
        Glide.with(context)
            .load(it)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(this)
    }
}

@SuppressLint("SimpleDateFormat")
@BindingAdapter("formatDate")
fun TextView.setDate(order_date: String) {
    var outputDate: String? = null
    try {
        val curFormater = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss")
        val postFormater = SimpleDateFormat("MMM dd, yyyy")

        val dateObj = curFormater.parse(order_date)
        outputDate = postFormater.format(dateObj!!)
        this.text = outputDate

    } catch (e: ParseException) {
        e.printStackTrace()
    }
}

