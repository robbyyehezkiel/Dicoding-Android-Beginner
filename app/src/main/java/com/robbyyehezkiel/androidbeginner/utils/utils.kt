package com.robbyyehezkiel.androidbeginner.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(@DrawableRes resource: Int, @DrawableRes placeholder: Int) {
    val options = RequestOptions()
        .placeholder(placeholder)
        .error(placeholder)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(resource)
        .into(this)
}
