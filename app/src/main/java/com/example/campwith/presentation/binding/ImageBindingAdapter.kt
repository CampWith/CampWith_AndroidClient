package com.example.campwith.presentation.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.campwith.R

@BindingAdapter("image_url")
fun setImageFromImageUrl(imageView: ImageView, imageUrl: String) {
    Glide.with(imageView.context)
        .load(imageUrl)
        .into(imageView)
}

@BindingAdapter("android:src")
fun setImageFromResource(imageView: ImageView, resource: Int) {
    Glide.with(imageView.context)
        .load(resource)
        .into(imageView)
}

@BindingAdapter("setBookmarkImage")
fun setBookmarkImage(imageView: ImageView, isBookmark: Boolean) {
    val resource = if (isBookmark) R.drawable.ic_heart_2 else R.drawable.ic_heart
    Glide.with(imageView.context)
        .load(resource)
        .into(imageView)
}