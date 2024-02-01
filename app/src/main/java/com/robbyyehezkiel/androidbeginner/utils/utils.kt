package com.robbyyehezkiel.androidbeginner.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide

fun ImageView.loadImage(@DrawableRes resource: Int, @DrawableRes placeholder: Int) {
    Glide.with(context)
        .load(resource)
        .placeholder(placeholder)
        .error(placeholder)
        .into(this)
}
