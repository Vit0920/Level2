package com.vkunitsyn.level2.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.addPictureGlide(url: String) {
    Glide.with(this)
        .load(url)
        .circleCrop()
        .override(200, 200)
        .into(this)
}

fun ImageView.addPictureGlide(drawable: Int) {
    Glide.with(this)
        .load(drawable)
        .circleCrop()
        .override(200, 200)
        .into(this)
}